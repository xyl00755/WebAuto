package com.zlshuo.selenium.nonaming.tools;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadXml {
	
	private static Document doc;
	private static String projectPath=Tools.getPath();
	
	/**
	 * ��ȡ�ڵ��ı�����
	 * @param node �ڵ���
	 * @return �ڵ��ı����ݣ�û��ȥ���ո�
	 */
	public static String getNodeValue(String node){
		buildParse(projectPath+"config\\config.xml");
		NodeList list=doc.getElementsByTagName(node);
		if(list!=null && list.getLength()==1){
				Element e=(Element) list.item(0);
				return e.getTextContent();
		}else
			return null;		
	}
	
	/**
	 * ��ȡ�ڵ�������ı�����
	 * @param node �ڵ�����
	 * @return �ڵ��ı���������
	 */
	public static ArrayList<String> getNodeValues(String node){
		ArrayList<String>  strArray = new ArrayList<String> ();
		buildParse(projectPath+"config\\config.xml");
		try{
			NodeList list=doc.getElementsByTagName(node);
			if(list!=null){
				for(int i=0;i<list.getLength();i++){
					Element e=(Element) list.item(i);
					strArray.add(e.getTextContent());
				}
			}
		}catch(Exception e){
			Log.info("�ڵ�"+node+"������");
		}
		
		return strArray;
	}
	
	/**
	 * ��ȡ�ڵ����������
	 * @param node �ڵ�
	 * @param str ������
	 * @return ����ֵ
	 */
	public static ArrayList<String> getNodeAttributes(String node,String str){
		ArrayList<String>  strArray = new ArrayList<String> ();
		buildParse(projectPath+"config\\config.xml");
		try{
			NodeList list=doc.getElementsByTagName(node);
			if(list!=null){
				for(int i=0;i<list.getLength();i++){
					Element e=(Element) list.item(i);
					try{
						strArray.add(e.getAttribute(str));
					}catch(Exception e1){
						Log.info("����"+str+"������");
					}
					
				}
			}
		}catch(Exception e){
			Log.info("�ڵ�"+node+"������");
		}
		return strArray;
	}
	
	/**
	 * ��ȡ�ڵ�����ֵ
	 * @param e
	 * @param str
	 * @return
	 */
	public static String getNodeAttribute(Element e,String str){
		return e.getAttribute(str);
	}
	
	/**
	 * �����ӽڵ��б�
	 * @param e ��Ԫ��
	 * @return �ӽڵ��б�
	 */
	private static NodeList getChildNodes(Element e){
		return e.getChildNodes();
	}
	
	/**
	 * ���ظ��ڵ��µ������ӽڵ�����
	 * @param str ���ڵ�
	 * @return
	 */
	public static ArrayList<String> getChildNodes(String str){
		ArrayList<String>  strArray = new ArrayList<String> ();
		buildParse(projectPath+"config\\config.xml");
		try{
			NodeList list=doc.getElementsByTagName(str);
			if(list!=null){
				for(int i=0;i<list.getLength();i++){
					Element e=(Element) list.item(i);
					NodeList childList=getChildNodes(e);
					try{
						//System.out.println(e.getNodeName());
						for(int j=0;j<childList.getLength();j++){
							Node chiledE=childList.item(j);
							if(chiledE instanceof Element)
								strArray.add(chiledE.getNodeName());
						}
					}catch(Exception e1){
						Log.info("�ڵ�"+str+"�²������ӽڵ�");
					}
					
				}
			}
		}catch(Exception e){
			Log.info("�ڵ�"+str+"������");
		}
		return strArray;
	}
	
	/**
	 * �����ĵ�����
	 * @param filePath
	 */
	private static void buildParse(String filePath){
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.parse(new File(filePath));
		}catch(Exception e){
			Log.error(filePath+"������");
			e.printStackTrace();
		}
	}
	
}
