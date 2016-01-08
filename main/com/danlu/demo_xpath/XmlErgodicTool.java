package com.danlu.demo_xpath;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 
 * 
 * 
 * <DL>
 * <DT><B> 递归遍历XML所有叶子节点的XPATH-JAVA </B></DT>
 * <p>
 * <DD>详细介绍</DD>
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
 * @Date: 2011-3-7 下午上午11:41:46
 */
public class XmlErgodicTool {

	/** XML编码 */
	private String encoding = "utf-8";

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding
	 *            the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * 
	 * 
	 * <DL>
	 * <DT><B> 标题 </B></DT>
	 * <DD>详细介绍</DD>
	 * </DL>
	 * 
	 * 
	 */
	public XmlErgodicTool() {

	}

	/**
	 * 
	 * <DL>
	 * <DT><B> 从一个字符串中，获取XML叶子Bean的列表 </B></DT>
	 * <DD>详细介绍</DD>
	 * </DL>
	 * 
	 * @param xmlString
	 * @param attrFilter
	 * @return
	 * 
	 */
	public List<XmlLeafBean> getXmlLeafBeanList(String xmlString,
			List<String> attrFilter) {
		List<XmlLeafBean> xmlLeafBeanList = new ArrayList<XmlLeafBean>();
		Document document = null;
		try {
			// xmlString = new String(xmlString.getBytes(), encoding);
			StringReader stringReader = new StringReader(xmlString);
			InputSource inputSource = new InputSource(stringReader);
			DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
			document = docBuilder.parse(inputSource);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Node node = document.getDocumentElement();
		this.getElementList(node, xmlLeafBeanList, "", attrFilter);

		return xmlLeafBeanList;
	}

	/**
	 * 
	 * 
	 * <DL>
	 * <DT><B> 从一个文件获取XML叶子Bean的列表 </B></DT>
	 * <DD>详细介绍</DD>
	 * </DL>
	 * 
	 * @param xmlFile
	 * @param attrFilter
	 * @return
	 * 
	 */
	public List<XmlLeafBean> getXmlLeafBeanList(File xmlFile,
			List<String> attrFilter) {
		List<XmlLeafBean> xmlLeafBeanList = new ArrayList<XmlLeafBean>();
		DocumentBuilderFactory dBuilderFac = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder dBuilder = null;
		Document document = null;
		try {
			dBuilder = dBuilderFac.newDocumentBuilder();
			document = dBuilder.parse(xmlFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Node node = document.getDocumentElement();
		this.getElementList(node, xmlLeafBeanList, "", attrFilter);
		this.createUniqueXmlLeafBeanList(xmlLeafBeanList, null, 0, 1);
		return xmlLeafBeanList;
	}

	/**
	 * 
	 * <DL>
	 * <DT><B> 递归遍历 Node取得XPath列表</B></DT>
	 * <DD>详细介绍</DD>
	 * </DL>
	 * 
	 * @param node
	 * @param xmlLeafBeanList
	 * @param currentNode
	 * @param filter
	 * 
	 */
	private void getElementList(Node node, List<XmlLeafBean> xmlLeafBeanList,
			String currentNode, List<String> filter) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			currentNode = currentNode + "/" + node.getNodeName();
			NamedNodeMap namedNodeMap = node.getAttributes();
			String nodeAttr = "[ ";
			for (int i = 0; i < namedNodeMap.getLength(); i++) {
				Node attribute = namedNodeMap.item(i);
				if (filter == null || filter.size() == 0) {
					String nameAttr = " and @" + attribute.getNodeName() + "='"
							+ attribute.getNodeValue() + "'";
					nodeAttr += nameAttr;
				} else if (filter.contains(attribute.getNodeName())) {
					String nameAttr = " and @" + attribute.getNodeName() + "='"
							+ attribute.getNodeValue() + "'";
					nodeAttr += nameAttr;
				}
			}
			nodeAttr += " ]";
			if (namedNodeMap.getLength() > 0 && nodeAttr.length() > 4) {
				int indexAnd = nodeAttr.indexOf(" and ");
				nodeAttr = nodeAttr.substring(0, indexAnd)
						+ nodeAttr.substring(indexAnd + (" and ").length());
				currentNode += nodeAttr;
			}
			NodeList nodeList = node.getChildNodes();
			for (int i = 0; nodeList != null && i < nodeList.getLength(); i++) {
				this.getElementList(nodeList.item(i), xmlLeafBeanList,
						currentNode, filter);
			}
		} else if (node.getNodeType() == Node.TEXT_NODE) {
			if (!("").equals(node.getNodeValue().trim())) {
				String xpath = currentNode;
				String value = node.getNodeValue();
				xmlLeafBeanList.add(new XmlLeafBean(xpath, value));
			}
		}
	}

	/**
	 * 
	 * 
	 * <DL>
	 * <DT><B> 创建XPath唯一的XmlLeafBeanList </B></DT>
	 * <DD>详细介绍</DD>
	 * </DL>
	 * 
	 * @param xmlLeafBeanList
	 * @param preXmlLeafBean
	 * @param listIndex
	 * @param eleIndex
	 * 
	 */
	public void createUniqueXmlLeafBeanList(List<XmlLeafBean> xmlLeafBeanList,
			XmlLeafBean preXmlLeafBean, int listIndex, int eleIndex) {
		if (listIndex == xmlLeafBeanList.size()) {
			return;
		}
		XmlLeafBean currentXmlLeafBean = xmlLeafBeanList.get(listIndex);
		listIndex++;
		if (preXmlLeafBean != null) {
			String preXPath = preXmlLeafBean.getXpath();
			preXPath = preXPath.replaceAll("\\[\\d+\\]", "");
			if (preXPath.equals(currentXmlLeafBean.getXpath())) {
				preXmlLeafBean.setXpath(preXPath + "["
						+ eleIndex + "]");
				currentXmlLeafBean.setXpath(currentXmlLeafBean.getXpath() + "["
						+ (eleIndex + 1) + "]");
				eleIndex += 1;
			} else {
				eleIndex = 1;
			}
		}
		this.createUniqueXmlLeafBeanList(xmlLeafBeanList, currentXmlLeafBean,
				listIndex, eleIndex);
	}

	public static void main(String args[]) {
		List<String> attrFilter = new ArrayList<String>();
		attrFilter.add("name");

		String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
				+ "<doc>\n" + "    <person>\n" + "        <name>某人</name>\n"
				+ "        <adds>            \n"
				+ "            <add ID=\"10002\">\n"
				+ "                <BS>10002</BS>\n"
				+ "                <note>西安市太白路</note>\n"
				+ "            </add>\n" + "            <add ID=\"\">\n"
				+ "                <BS>10002</BS>\n"
				+ "                <note>空ID节点啊</note>\n"
				+ "            </add>\n" + "            <add>\n"
				+ "                <BS>10002</BS>\n"
				+ "                <note>空ID节点啊</note>\n"
				+ "            </add>\n" + "\t\t\t<add ID=\"10001\">\n"
				+ "\t\t\t\t<BS xmlns=\"10001\"/>\n"
				+ "                <note>西安市太白路2</note>\n"
				+ "            </add>\n" + "\t\t</adds>\n" + "    </person>\n"
				+ "    <other>\n" + "        <name ID=\"HEHE\">ASDF</name>\n"
				+ "    </other>\n" + "</doc>";
		XmlErgodicTool xmlErgodicTool1 = new XmlErgodicTool();
		List<XmlLeafBean> xmlLeafBeanList = xmlErgodicTool1.getXmlLeafBeanList(
				xmlString, attrFilter);
		for (XmlLeafBean xmlLeafBean : xmlLeafBeanList) {
			System.out.println(xmlLeafBean.getXpath() + " , "
					+ xmlLeafBean.getValue());
		}

		System.out.println("__________");

		XmlErgodicTool xmlErgodicTool2 = new XmlErgodicTool();
		List<XmlLeafBean> xmlLeafBeanList2 = xmlErgodicTool2
				.getXmlLeafBeanList(
						new File("C:\\Users\\stray\\Desktop\\s.xml"),
						attrFilter);
		for (XmlLeafBean xmlLeafBean : xmlLeafBeanList2) {
			System.out.println(xmlLeafBean.getXpath() + " , "
					+ xmlLeafBean.getValue());
		}
	}
}
