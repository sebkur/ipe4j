//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.15 at 11:24:44 AM CEST 
//

package de.topobyte.ipe.jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "cmap")
public class Cmap
{

	@XmlAttribute(name = "font", required = true)
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String font;

	/**
	 * Gets the value of the font property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFont()
	{
		return font;
	}

	/**
	 * Sets the value of the font property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFont(String value)
	{
		this.font = value;
	}

}
