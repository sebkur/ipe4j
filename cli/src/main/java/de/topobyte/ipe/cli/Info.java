package de.topobyte.ipe.cli;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

import de.topobyte.ipe.jaxb.model.Ipe;
import de.topobyte.ipe.jaxb.model.Page;
import de.topobyte.utilities.apache.commons.cli.OptionHelper;
import de.topobyte.utilities.apache.commons.cli.commands.args.CommonsCliArguments;
import de.topobyte.utilities.apache.commons.cli.commands.options.CommonsCliExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptions;
import de.topobyte.utilities.apache.commons.cli.commands.options.ExeOptionsFactory;

public class Info
{

	private static final String OPTION_VIEWS = "views";

	public static ExeOptionsFactory OPTIONS_FACTORY = new ExeOptionsFactory() {

		@Override
		public ExeOptions createOptions()
		{
			Options options = new Options();
			OptionHelper.addL(options, OPTION_VIEWS, false, false,
					"Display information about views");
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

		boolean showViewDetails = line.hasOption(OPTION_VIEWS);

		JAXBContext jaxbContext = JAXBContext.newInstance(Ipe.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Path file = Paths.get(args.get(0));
		InputStream is = Files.newInputStream(file);

		XMLInputFactory xif = XMLInputFactory.newFactory();
		xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
		XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(is));

		Ipe ipe = (Ipe) jaxbUnmarshaller.unmarshal(xsr);
		System.out.println("creator: " + ipe.getCreator());
		System.out.println("version: " + ipe.getVersion());

		System.out.println("#pages: " + ipe.getPage().size());

		if (showViewDetails) {
			for (int i = 0; i < ipe.getPage().size(); i++) {
				Page page = ipe.getPage().get(i);
				System.out.println(String.format("page %d: %d views", i + 1,
						page.getView().size()));
			}
		}
	}

}
