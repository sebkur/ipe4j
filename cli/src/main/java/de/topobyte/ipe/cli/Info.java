package de.topobyte.ipe.cli;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import de.topobyte.ipe.jaxb.model.Ipe;

public class Info
{

	public static void main(String[] args)
			throws JAXBException, XMLStreamException, IOException
	{
		if (args.length != 1) {
			System.out.println("usage: info <file>");
			System.exit(1);
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(Ipe.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Path file = Paths.get(args[0]);
		InputStream is = Files.newInputStream(file);

		XMLInputFactory xif = XMLInputFactory.newFactory();
		xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
		XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(is));

		Ipe ipe = (Ipe) jaxbUnmarshaller.unmarshal(xsr);
		System.out.println("creator: " + ipe.getCreator());
		System.out.println("version: " + ipe.getVersion());

		System.out.println("#pages: " + ipe.getPage().size());
	}

}
