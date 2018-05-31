package com.csg.sone.base.helper;


import org.dom4j.*;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * <p> Description:  XmlHelperTest </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author sultan
 * @version 1.0
 */
public class XmlHelperTest {
    @Test
    public void createDocument() {
        Document document = XmlHelper.createDocument();
        Element root = XmlHelper.createElement("root");
        document = XmlHelper.createDocument(root);

        Element classes = XmlHelper.createElement("classes");
        root.add(classes);
        Attribute name = XmlHelper.createAttribute(classes, "name", "第一班");
        Attribute count = XmlHelper.createAttribute(classes, "count", "3");
        classes.add(name);
        classes.add(count);

        Element student1 = XmlHelper.createElement("student1");
        classes.add(student1);
        Element name1 = XmlHelper.createElement("name");
        Text allen = XmlHelper.createText("allen");
        name1.add(allen);

        Element age1 = XmlHelper.createElement("age");
        Text age = XmlHelper.createText("18");
        age1.add(age);

        Element script = XmlHelper.createElement("script");
        CDATA cdata = XmlHelper.createCDATA("function json(){var i=0;i>0;}");
        script.add(cdata);

        student1.add(name1);
        student1.add(age1);
        student1.add(script);

        String xmlStr;
        xmlStr = XmlHelper.doc2XmlString(document);
        System.out.print(xmlStr);
        Document dcmt = XmlHelper.parseDoc(xmlStr);
        String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String fileName = "row2.xml";
        XmlHelper.doc2Xml(dcmt, classPath + fileName, "UTF-8");
    }

    @Test
    public void getDoc() {
        Document document = XmlHelper.getDoc("row2.xml");
        Element student1 = XmlHelper.getNodeByXPath(document, "/root/classes/student1");

        Element count = XmlHelper.getSubElement(student1, "name");
        assertThat(count.getText(), equalTo("allen"));

        assertThat(XmlHelper.getSubElementText(student1, "name"), equalTo("allen"));

        String name = XmlHelper.getSubElementAttrVal(document.getRootElement(), "classes", "name");
        assertEquals(name, "第一班");
    }


}
