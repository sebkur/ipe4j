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
@XmlRootElement(name = "pathstyle")
public class Pathstyle
{

	@XmlAttribute(name = "cap")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String cap;
	@XmlAttribute(name = "join")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String join;
	@XmlAttribute(name = "fillrule")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String fillrule;

	/**
	 * Gets the value of the cap property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCap()
	{
		return cap;
	}

	/**
	 * Sets the value of the cap property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCap(String value)
	{
		this.cap = value;
	}

	/**
	 * Gets the value of the join property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getJoin()
	{
		return join;
	}

	/**
	 * Sets the value of the join property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setJoin(String value)
	{
		this.join = value;
	}

	/**
	 * Gets the value of the fillrule property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFillrule()
	{
		return fillrule;
	}

	/**
	 * Sets the value of the fillrule property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFillrule(String value)
	{
		this.fillrule = value;
	}

}
