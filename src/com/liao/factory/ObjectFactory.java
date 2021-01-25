package com.liao.factory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.dom4j.Dom4jXPath;

@SuppressWarnings("all")
public class ObjectFactory {


    public static void main(String[] args) {

    }


    private static Map<String, Object> map = new HashMap<String, Object>();

    static {
        SAXReader reader = new SAXReader();
        try {
//			使用阅读器读取xml文档
            Document document = reader.read
                    (Dom4jXPath.class.getClassLoader().getResourceAsStream("bean.xml"));
//			获取root节点
            Element element = document.getRootElement();
//			获取root节点的子节点
            Iterator<Element> iterator = element.elementIterator();
//			遍历迭代器
            while (iterator.hasNext()) {
                Element e = iterator.next();
                String key = e.attributeValue("id");
                Object value = Class.forName(e.attributeValue("class")).newInstance();
                map.put(key, value);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


//		BufferedReader read =
//			new BufferedReader(
//					new InputStreamReader(
//							ObjectFactory.class.getClassLoader
//							().getResourceAsStream("bean.txt")));
//		
//		String str = "";
//		try {
//			while((str = read.readLine()) != null){
//				String strs [] = str.split("=");
//				String key = strs[0];
//				Object value = Class.forName(strs[1]).newInstance();
//				map.put(key, value);
//				
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }

    public static Object getBean(String key) {
        return map.get(key);
    }

}







