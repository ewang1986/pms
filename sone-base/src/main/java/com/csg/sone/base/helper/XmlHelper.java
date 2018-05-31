package com.csg.sone.base.helper;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * <p> Description:  XmlHelper </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */

public final class XmlHelper {

    /**
     * <p>创建一个XML文档对象.
     * </p>
     *
     * @return Document
     */
    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();
        return document;
    }

    /**
     * <p>创建一个XML文档对象,并添加根节点元素.
     * </p>
     *
     * @param rootElement
     * @return Document
     */
    public static Document createDocument(Element rootElement) {
        Document document = DocumentHelper.createDocument();
        document.add(rootElement);
        return document;
    }

    /**
     * <p>创建一个XML元素对象.
     * </p>
     *
     * @param name
     * @return Element
     */
    public static Element createElement(String name) {

        return DocumentHelper.createElement(name);
    }

    /**
     * <p>为一个元素创建一个属性对象.
     * </p>
     *
     * @param owner
     * @param name
     * @param value
     * @return Attribute
     */
    public static Attribute createAttribute(Element owner, String name, String value) {
        return DocumentHelper.createAttribute(owner, name, value);
    }

    /**
     * <p>创建一个CDATA对象.
     * </p>
     *
     * @param text
     * @return CDATA
     */
    public static CDATA createCDATA(String text) {
        return DocumentHelper.createCDATA(text);
    }

    /**
     * <p>创建一个文本对象.
     * </p>
     *
     * @param text
     * @return Text
     */
    public static Text createText(String text) {
        return DocumentHelper.createText(text);
    }

    /**
     * <p>保存Document到XML文件.
     * </p>
     *
     * @param doc
     * @param xmlPath
     * @param charset
     */
    public static void doc2Xml(Document doc, String xmlPath, String charset) {
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding(charset);
            XMLWriter writer = new XMLWriter(new FileOutputStream(xmlPath), format);
            writer.write(doc);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>保存Document到XML文件，默认为UTF-8格式.
     * </p>
     *
     * @param doc
     * @param xmlPath
     */
    public static void doc2Xml(Document doc, String xmlPath) {
        doc2Xml(doc, xmlPath, "UTF-8");
    }


    /**
     * <p>保存Document到字符串.
     * </p>
     *
     * @param doc
     * @param charset
     */
    public static String doc2XmlString(Document doc, String charset) {
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding(charset);
            StringWriter out = new StringWriter();
            XMLWriter writer = new XMLWriter(out, format);
            writer.write(doc);
            writer.close();
            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <p>保存Document到字符串，默认为UTF-8格式.
     * </p>
     *
     * @param doc
     */
    public static String doc2XmlString(Document doc) {
        return doc2XmlString(doc, "UTF-8");
    }

    /**
     * <p>根据XML文件的classpath，获取Document对象.
     * </p>
     *
     * @param classPath
     * @return Document
     */
    public static Document getDoc(String classPath) {
        SAXReader saxReader = new SAXReader();

        Document doc = null;
        try {
            classPath = classPath.trim();

            doc = saxReader.read(Thread.currentThread().getContextClassLoader().getResourceAsStream(classPath));
        } catch (Exception e) {

            e.printStackTrace();
        }
        return doc;
    }

    /**
     * <p>获取子元素Element对象.
     * </p>
     * <per>
     * xml =<root><node1></node1><node2></node2></root>
     * getSubElement(xml,"node2") = <node2></node2>
     * </per>
     *
     * @param element
     * @param strName
     * @return Element
     */
    public static Element getSubElement(Element element, String strName) {
        Element subElment = element.element(strName);
        return subElment;
    }

    /**
     * <p>获取子元素Element对象文本内容.
     * </p>
     * <per>
     * xml =<root><node1>text</node1><node2></node2></root>
     * getSubElementText(xml,"node1") = text
     * </per>
     *
     * @param element
     * @param strName
     * @return String
     */
    public static String getSubElementText(Element element, String strName) {
        String strText = "";
        Element subElment = element.element(strName);
        if (subElment != null) {
            strText = subElment.getText();
        }

        return strText;
    }

    /**
     * <p>获取子元素Element对象属性内容.
     * </p>
     * <per>
     * xml =<root><node1 name="allen">text</node1><node2></node2></root>
     * getSubElementAttrVal(xml,"node1","name") = allen
     * </per>
     *
     * @param element
     * @param subEl
     * @param attr
     * @return String
     */
    public static String getSubElementAttrVal(Element element, String subEl, String attr) {
        String strText = "";
        Element subElment = element.element(subEl);
        if (subElment != null) {
            strText = subElment.attribute(attr).getValue();
        }
        return strText;
    }

    /**
     * <p>根据xPath，获取节点元素列表.
     * </p>
     * <per>
     * xml =<root><node1>text</node1><node2></node2></root>
     * getNodeByXPath(xml,"/root/node2") = <node2></node2>
     * </per>
     *
     * @param doc
     * @param xPath
     * @return Element
     */
    public static Element getNodeByXPath(Document doc, String xPath) {
        Element element = (Element) doc.selectSingleNode(xPath);
        return element;
    }


    /**
     * <p>根据字符串文本获取XML文档的Document对象.
     * </p>
     *
     * @param xmlText
     */
    public static Document parseDoc(String xmlText) {
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xmlText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

}
