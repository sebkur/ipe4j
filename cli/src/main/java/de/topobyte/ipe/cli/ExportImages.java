package de.topobyte.ipe.cli;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import de.topobyte.ipe.jaxb.model.Bitmap;
import de.topobyte.ipe.jaxb.model.Ipe;
import de.topobyte.utilities.apache.commons.cli.OptionHelper;
import de.topobyte.utilities.apache.commons.cli.commands.args.CommonsCliArguments;
import de.topobyte.utilities.apache.commons.cli.commands.options.CommonsCliExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptionsFactory;

public class ExportImages
{

	private static final String OPTION_OUTPUT = "output";

	public static ExeOptionsFactory OPTIONS_FACTORY = new ExeOptionsFactory() {

		@Override
		public ExeOptions createOptions()
		{
			Options options = new Options();
			OptionHelper.addL(options, OPTION_OUTPUT, true, true,
					"Output directory");
			return new CommonsCliExeOptions(options, "[options] <file>");
		}

	};

	public static void main(String exename, CommonsCliArguments arguments)
			throws JAXBException, XMLStreamException, IOException
	{
		CommandLine line = arguments.getLine();
		List<String> args = line.getArgList();

		if (args.size() < 1) {
			System.out.println("Please specify a filename");
			arguments.getOptions().usage(exename);
			System.exit(1);
		}

		String argOutput = line.getOptionValue(OPTION_OUTPUT);
		Path dir = Paths.get(argOutput);

		Files.createDirectories(dir);

		JAXBContext jaxbContext = JAXBContext.newInstance(Ipe.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Path file = Paths.get(args.get(0));
		InputStream is = Files.newInputStream(file);

		XMLInputFactory xif = XMLInputFactory.newFactory();
		xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
		XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(is));

		Ipe ipe = (Ipe) jaxbUnmarshaller.unmarshal(xsr);

		List<Object> bitmapOrIpestyle = ipe.getBitmapOrIpestyle();
		List<Bitmap> bitmaps = Lists
				.newArrayList(Iterables.filter(bitmapOrIpestyle, Bitmap.class));
		for (int i = 0; i < bitmaps.size(); i++) {
			Bitmap bitmap = bitmaps.get(i);
			System.out.println(String.format(
					"bitmap %d width: %s, height: %s, encoding: %s", i,
					bitmap.getWidth(), bitmap.getHeight(),
					bitmap.getEncoding()));
			Path output = dir.resolve(String.format("%d.png", i + 1));
			System.out.println(String.format("Storing as: %s", output));

			exportBitmap(bitmap, output);
		}
	}

	private static void exportBitmap(Bitmap bitmap, Path output)
			throws IOException
	{
		String value = bitmap.getvalue();
		String trimmed = value.trim();
		byte[] base64 = trimmed.getBytes(StandardCharsets.UTF_8);
		byte[] data = Base64.getMimeDecoder().decode(base64);
		System.out.println(String.format("data length: %d", data.length));
		OutputStream os = Files.newOutputStream(output);
		os.write(data);
		os.close();
	}

}
