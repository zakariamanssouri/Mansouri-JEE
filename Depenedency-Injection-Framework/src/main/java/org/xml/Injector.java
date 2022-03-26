package org.xml;

import com.sun.xml.internal.ws.util.StringUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Injector {
    private String config_path;
    private HashMap<String, Object> ServiceBeans = new HashMap<String, Object>();
    private HashMap<String, Object> ClientBeans = new HashMap<String, Object>();

    public Injector(String config_path) {
        List<String> clientsclasses = new ArrayList<String>();
        List<String> servicesclasses= new ArrayList<String>();
        this.config_path = config_path;


        try {
            DocumentBuilder db =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(new File(config_path));
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression expression_beans = xPath.compile("//bean");
            final NodeList beans = (NodeList) expression_beans.evaluate(doc, XPathConstants.NODESET);
            Element bean;
            for (int i = 0; i < beans.getLength(); i++) {
                bean = (Element) beans.item(i);

                if (!bean.hasChildNodes()) {
                    String beanname = bean.getAttribute("name").equals("") ? bean.getAttribute("class") : bean.getAttribute("name");
                    String classname = bean.getAttribute("class");
                    InstantiateServiceClasse(classname,beanname);
                }
                else
                {
                    String beanname = bean.getAttribute("name").equals("") ? bean.getAttribute("class") : bean.getAttribute("name");
                    String classname = bean.getAttribute("class");
                    String ref,name;
                    Node node = bean.getElementsByTagName("property").item(0);
                    Element property = (Element) node;
                    ref = property.getAttribute("ref"); //ref of object to be injected
                    name = property.getAttribute("name");
                    InstantiateClientClasse(classname,beanname);
                    Object serviceObject = getBean(ref);
                    Object clientobject = getBean(beanname);
                    String methodname = "set" + StringUtils.capitalize(name);
                    Method methods[] = clientobject.getClass().getMethods();
                    Method method=null;
                    for (Method method_ : methods) {
                        if (methodname.equals(method_.getName())) {
                            method = method_;
                        }
                    }
                    method.invoke(clientobject,serviceObject);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }



    }

    public Object getBean(String beaname) {
        Object object=null;
        for (HashMap.Entry<String, Object> entry : ServiceBeans.entrySet()) {
            if (entry.getKey().equals(beaname)) {
                object= entry.getValue();
                return object;
            }
        }
        for (HashMap.Entry<String, Object> entry : ClientBeans.entrySet()) {
            if (entry.getKey().equals(beaname)) {
                object = entry.getValue();
                return object;
            }
        }
        return object;
    }

    private void InstantiateServiceClasse(String classname,String BeanName) {
        try {
            Class beanclasse = Class.forName(classname);
            Object beanobj = beanclasse.newInstance();
            ServiceBeans.put(BeanName, beanobj);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void InstantiateClientClasse(String classname, String BeanName) {
        try {
            Class beanclasse = Class.forName(classname);
            Object beanobj = beanclasse.newInstance();
            ClientBeans.put(BeanName, beanobj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
