package cn.sharit;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null) {
                    return super.findClass(name);

                }
                byte[] bytes;
                try {
                    bytes = new byte[inputStream.available()];
                    inputStream.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Class<?> aClass = cl.loadClass("cn.sharit.ClassLoaderTest");
        System.out.println(aClass);
//        Object instance = aClass.newInstance();
//        System.out.println(instance.getClass());
//        System.out.println(instance instanceof cn.sharit.ClassLoaderTest);

    }

}
