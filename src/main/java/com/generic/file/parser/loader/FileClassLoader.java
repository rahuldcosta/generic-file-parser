package com.generic.file.parser.loader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class FileClassLoader extends ClassLoader {

    public Object invokeClassMethod(String classBinName, String methodName,String type) {

        try {
            ClassLoader classLoader = this.getClass().getClassLoader();

            Class loadedClass = classLoader.loadClass(classBinName);
            Constructor constructor = loadedClass.getConstructor();
            Object classObject = constructor.newInstance();

            Class<?>[] methodParams = new Class<?>[1];
            methodParams[0] = String.class;
            Method classMethod = loadedClass.getDeclaredMethod(methodName,methodParams);
            return classMethod.invoke(classObject,type);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
