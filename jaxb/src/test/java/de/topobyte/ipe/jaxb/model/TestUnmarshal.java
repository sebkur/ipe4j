package de.topobyte.ipe.jaxb.model;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

public class TestUnmarshal
{

	public static void main(String[] args) throws JAXBException,
			ParserConfigurationException, SAXException, XMLStreamException
	{
		JAXBContext jaxbContext = JAXBContext.newInstance(Ipe.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("test.xml");

		XMLInputFactory xif = XMLInputFactory.newFactory();
		xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
		XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(is));

		Ipe ipe = (Ipe) jaxbUnmarshaller.unmarshal(xsr);
		System.out.println("creator: " + ipe.getCreator());
		System.out.println("version: " + ipe.getVersion());

		System.out.println("#pages: " + ipe.getPage().size());
	}

}
