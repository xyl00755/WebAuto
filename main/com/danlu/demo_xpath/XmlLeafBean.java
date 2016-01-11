package com.danlu.demo_xpath;

/**
 * 
 * <DL>
 * <DT><B> xml的叶子节点的Bean </B></DT>
 * <p>
 * <DD>详细介绍</DD>
 * <DD>这个Bean用来存放叶子节点的XPath 和 对应的Value</DD>
 * </DL>
 * <p>
 * 
 * <DL>
 * <DT><B>使用范例</B></DT>
 * <p>
 * <DD>使用范例说明</DD>
 * </DL>
 * <p>
 * 
 * @author 周典
 * @version
 * @Date: 2011-3-7 下午上午11:03:52
 * 
 */
public class XmlLeafBean {

	private String xpath;

	private String value;

	public XmlLeafBean() {

	}

	/**
	 * 
	 * <DL>
	 * <DT><B> 标题 </B></DT>
	 * <DD>详细介绍</DD>
	 * </DL>
	 * 
	 * @param xpath
	 * @param value
	 * 
	 */
	public XmlLeafBean(String xpath, String value) {
		this.xpath = xpath;
		this.value = value;
	}

	/**
	 * @return the xpath
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * @param xpath
	 *            the xpath to set
	 */
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}