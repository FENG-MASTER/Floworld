package com.fengmaster.game.floworld.util;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Enumeration;

public class ClassUtil {
    // getClassName("top.lingkang.demohibernate.entity")
    public static Class[] getClassByPackage(String packageName) {
        try {
            Enumeration<URL> resources = ClassUtil.class.getClassLoader().getResources(packageName.replaceAll("\\.", "/"));
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String[] file = new File(url.getFile()).list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".class");
                    }
                });
                Class[] classList = new Class[file.length];
                for (int i = 0; i < file.length; i++) {
                    classList[i] = Class.forName(packageName + "." + file[i].replaceAll("\\.class", ""));
                }
                return classList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
