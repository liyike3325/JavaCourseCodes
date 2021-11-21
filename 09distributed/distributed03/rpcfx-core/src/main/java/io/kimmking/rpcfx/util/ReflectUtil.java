package io.kimmking.rpcfx.util;

import java.io.File;
import java.net.URL;
import java.util.*;

public class ReflectUtil {

    public static Object getInterfaceImpl(String serviceClass) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> target = Class.forName(serviceClass);
        if (!target.isInterface()) {
            return null;
        }
        String basePackage = ReflectUtil.class.getClassLoader().getResource("").getPath();
        File[] files = new File(basePackage).listFiles();
        // 存放class路径的list
        ArrayList<String> classpaths = new ArrayList<>();
        for (File file : files) {
            // 扫描项目编译后的所有类
            if (file.isDirectory()) {
                listPackages(file.getName(), classpaths);
            }
        }
        // 获取所有类，然后判断是否是target接口实现类
        for (String classpath : classpaths) {
            Class<?> classObject = Class.forName(classpath);
            // 判断该对象的父类是否为null
            if (classObject.getSuperclass() == null) {
                continue;
            }
            Set<Class<?>> interfaces = new HashSet<>(Arrays.asList(classObject.getInterfaces()));
            if (interfaces.contains(target)) {
                return Class.forName(classObject.getName()).newInstance();
            }
        }
        return null;
    }

    public static void listPackages(String basePackage, List<String> classes) {
        URL url = ReflectUtil.class.getClassLoader().getResource("./" +
                basePackage.replaceAll("\\.", "/"));
        File directory = new File(url.getFile());
        for (File file : directory.listFiles()) {
            // 如果是一个目录就继续往下读取（递归调用）
            if (file.isDirectory()) {
                listPackages(basePackage + "." + file.getName(), classes);
            } else {
                // 如果不是一个目录，判断是不是以.class结尾的文件，如果不是则不作处理
                String classpath = file.getName();
                if (".class".equals(classpath.substring(classpath.length() - ".class".length()))) {
                    classes.add(basePackage + "." + classpath.replaceAll(".class", ""));
                }
            }
        }
    }
}
