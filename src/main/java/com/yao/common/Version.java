package com.yao.common;

import org.springframework.beans.BeanUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yao on 15/7/17.
 */
public class Version {

    public static String getVersion(Class<?>cls,String defaultVersion){
        try {
            //首先查找MANIFEST.MF规范中的版本号
            String version = cls.getPackage().getImplementationVersion();
            if (version == null || version.length() == 0) {
                version = cls.getPackage().getSpecificationVersion();
            }
            if (version == null || version.length() == 0) {
                CodeSource codeSource = cls.getProtectionDomain().getCodeSource();
                if (codeSource == null) {
                    if (codeSource == null) {
                        System.out.println("No codeSource for class " + cls.getName() + " when getVersion, use default version " + defaultVersion);
                    }
                } else {
                    String file = codeSource.getLocation().getFile();
                    if (file != null && file.length() > 0 && file.endsWith(".jar")) {
                        file = file.substring(0, file.length() - 4);
                        int i = file.lastIndexOf('/');
                        if (i >= 0) {
                            file = file.substring(i + 1);
                        }
                        while (file.length() > 0 && !Character.isDigit(file.charAt(0))) {
                            i = file.indexOf("-");
                            if (i >= 0) {
                                file = file.substring(i + 1);
                            } else {
                                break;
                            }
                        }
                        version = file;

                    }

                }
            }

            return version == null || version.length() == 0 ? defaultVersion : version;
        }catch (Throwable e){
            return defaultVersion;
        }
    }

    public static void checkDuplicate(String path,boolean failOnError){
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(path);
            Set<String> files=new HashSet<>();
            while (urls.hasMoreElements()){
                URL url=urls.nextElement();
                if(url!=null){
                    String file=url.getFile();
                    if(file!=null&&file.length()>0){
                        files.add(file);
                    }
                }
            }
            if (files.size() > 1) {
                String error = "Duplicate class " + path + " in " + files.size() + " jar " + files;
                if (failOnError) {
                    throw new IllegalStateException(error);
                }
            }

        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public static void checkDuplicate(Class<?> cls, boolean failOnError) {
        checkDuplicate(cls.getName().replace('.', '/') + ".class", failOnError);
    }

    public static void checkDuplicate(Class<?> cls) {
        checkDuplicate(cls, false);
    }
    public static void main(String[]args){
        System.out.println(getVersion(Version.class,"1"));
        System.out.println(getVersion(ClassPathXmlApplicationContext.class,"1"));


        checkDuplicate(BeanUtils.class);

    }


}
