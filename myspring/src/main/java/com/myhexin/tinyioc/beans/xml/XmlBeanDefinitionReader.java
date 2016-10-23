package com.myhexin.tinyioc.beans.xml;

import com.myhexin.tinyioc.BeanDefinition;
import com.myhexin.tinyioc.beans.AbstractBeanDefinitionReader;
import com.myhexin.tinyioc.beans.PropertyValue;
import com.myhexin.tinyioc.beans.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : lvcf on 2016/10/23 14:24
 * @Description : 通过解析xml文件实现BreanDefinitionReader
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        InputStream in = getResourceLoader().gerResource(location).getInputStream();
        doLoadBeanDefinitions(in);
    }

    private void doLoadBeanDefinitions(InputStream in) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(in);
        NodeList nodeList = doc.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element)
                parseBeanDefinition((Element) node);
        }
    }

    private void parseBeanDefinition(Element node) {
        String beanName = node.getAttribute("name");
        String className = node.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(node,beanDefinition);
        beanDefinition.setBeanClass(className);
        getMap().put(beanName,beanDefinition);
    }

    /**
     * 装配属性
     * @param node
     * @param beanDefinition
     */
    private void processProperty(Element node, BeanDefinition beanDefinition) {
        NodeList propertyNode = node.getElementsByTagName("property");
        for(int i = 0;i<propertyNode.getLength();i++){
            Node n = propertyNode.item(i);
            if(n instanceof Element){
                Element e = (Element) n;
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(e.getAttribute("name"),e.getAttribute("value")));
            }
        }
    }


}
