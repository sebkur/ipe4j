//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.15 at 11:24:44 AM CEST 
//

package de.topobyte.ipe.jaxb.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "notes", "layer", "view",
		"groupOrImageOrUseOrTextOrPath" })
@XmlRootElement(name = "page")
public class Page
{

	@XmlAttribute(name = "title")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String title;
	@XmlAttribute(name = "section")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String section;
	@XmlAttribute(name = "subsection")
	@XmlJavaTypeAdapter(NormalizedStringAdapter.class)
	protected String subsection;
	@XmlAttribute(name = "marked")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String marked;
	protected String notes;
	protected List<Layer> layer;
	protected List<View> view;
	@XmlElements({ @XmlElement(name = "group", type = Group.class),
			@XmlElement(name = "image", type = Image.class),
			@XmlElement(name = "use", type = Use.class),
			@XmlElement(name = "text", type = Text.class),
			@XmlElement(name = "path", type = Path.class) })
	protected List<Object> groupOrImageOrUseOrTextOrPath;

	/**
	 * Gets the value of the title property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Sets the value of the title property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitle(String value)
	{
		this.title = value;
	}

	/**
	 * Gets the value of the section property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSection()
	{
		return section;
	}

	/**
	 * Sets the value of the section property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSection(String value)
	{
		this.section = value;
	}

	/**
	 * Gets the value of the subsection property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSubsection()
	{
		return subsection;
	}

	/**
	 * Sets the value of the subsection property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSubsection(String value)
	{
		this.subsection = value;
	}

	/**
	 * Gets the value of the marked property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMarked()
	{
		if (marked == null) {
			return "yes";
		} else {
			return marked;
		}
	}

	/**
	 * Sets the value of the marked property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMarked(String value)
	{
		this.marked = value;
	}

	/**
	 * Gets the value of the notes property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * Sets the value of the notes property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNotes(String value)
	{
		this.notes = value;
	}

	/**
	 * Gets the value of the layer property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the layer property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLayer().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Layer }
	 * 
	 * 
	 */
	public List<Layer> getLayer()
	{
		if (layer == null) {
			layer = new ArrayList<Layer>();
		}
		return this.layer;
	}

	/**
	 * Gets the value of the view property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the view property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getView().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link View }
	 * 
	 * 
	 */
	public List<View> getView()
	{
		if (view == null) {
			view = new ArrayList<View>();
		}
		return this.view;
	}

	/**
	 * Gets the value of the groupOrImageOrUseOrTextOrPath property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the groupOrImageOrUseOrTextOrPath property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getGroupOrImageOrUseOrTextOrPath().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Group }
	 * {@link Image } {@link Use } {@link Text } {@link Path }
	 * 
	 * 
	 */
	public List<Object> getGroupOrImageOrUseOrTextOrPath()
	{
		if (groupOrImageOrUseOrTextOrPath == null) {
			groupOrImageOrUseOrTextOrPath = new ArrayList<Object>();
		}
		return this.groupOrImageOrUseOrTextOrPath;
	}

}
