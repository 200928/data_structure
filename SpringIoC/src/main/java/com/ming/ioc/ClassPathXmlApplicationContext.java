package com.ming.ioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/18 - 下午10:38
 * @ Description: com.ming.ioc
 * @ Version: 1.0
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map<String, Object> ioc = new HashMap<>();

    public ClassPathXmlApplicationContext(String path) {

        try {
            // 解析XML实例
            SAXReader saxReader = new SAXReader();
            // 保存解析的XML数据
            Document document = saxReader.read(path);
//            System.out.println(document);
            // 获取根标签数据
            Element beans = document.getRootElement();
            // 获取根标签的迭代器
            Iterator<Element> beansIterator = beans.elementIterator();
            // 遍历根标签的元素,也就是遍历 Beans 里面的每个 Bean
            while (beansIterator.hasNext()) {
                // 获取 Beans 下面的每个 Bean
                Element element = beansIterator.next();
                String id = element.attributeValue("id"); // 获取 Bean 的 id
                String className = element.attributeValue("class"); // 获取 Bean 的 Class,类的全程
                // 通过获取的全类名利用反射得到 Class 对象
                Class<?> aClass = Class.forName(className);
                // 根据得到的反射对象的 getConstructor() 方法获得无参构造
                Constructor<?> constructor = aClass.getConstructor();
                // 根据构造方法创建对象
                Object object = constructor.newInstance();
                // 得到 bean 的迭代器,里面有 property
                Iterator<Element> beanIterator = element.elementIterator();
                while (beanIterator.hasNext()) {
                    Element property = beanIterator.next();
                    String name = property.attributeValue("name");
                    String value = property.attributeValue("value");
                    String methodName = "set" + name.substring(0, 1).toUpperCase(Locale.ROOT) + name.substring(1);
                    System.out.println(methodName);
                }
                // 获取 aClass 类的所有方法
//                Method[] methods = aClass.getDeclaredMethods();
//                for (Method method : methods) {
//                    System.out.println(method);
//                }
                System.out.println(object);
//                System.out.println(constructor);
//                System.out.println("id:" + id + ",class:" + className);
            }
//            System.out.println(root);
        } catch (DocumentException | ClassNotFoundException
                | NoSuchMethodException | InvocationTargetException
                | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
