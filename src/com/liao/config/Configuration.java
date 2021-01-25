package com.liao.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.liao.util.ControllerMapping;

@SuppressWarnings("all")
/**
 * 读取mvc.xml配置文件 并将配置信息保存在集合中
 * @author Administrator
 *
 */
public class Configuration {

    // 创建集合  保存 mvc.xml 解析之后的 集合
    Map<String, ControllerMapping> controllMap = new HashMap<String, ControllerMapping>();


    /**
     * 读取mvc.xml
     */
    public Map<String, ControllerMapping> getControllerMapping() {


        try {
            // 创建SAX解析器
            SAXReader reader = new SAXReader();

            // 使用SAX解析器 读取对应的配置文件
            Document document = reader.read(Configuration.class.getClassLoader().getResourceAsStream("mvc.xml"));

            // 读取根节点
            Element root = document.getRootElement();

            // 根据根节点获取 子节点
            Iterator<Element> iterator = root.elementIterator("controller");

            // 遍历子节点
            while (iterator.hasNext()) {
                // 获取当前 遍历到的子节点
                Element element = iterator.next();

                // 根据属性名获取 节点中 对应的属性值
                String path = element.attributeValue("path");
                String className = element.attributeValue("class");
                String method = element.attributeValue("method");

                // 将数据组装成 ControllerMapping
                ControllerMapping mapping = new ControllerMapping(path, className, method);

                // 将数据 添加到集合中
                controllMap.put(path, mapping);
            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return controllMap;
    }


}
