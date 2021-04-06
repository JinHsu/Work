package cn.sharit;

public class ClassLoaderTest2 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest2.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent()); // BootstrapClassLoader
        //
        System.out.println(classLoader.getClass().getClassLoader());
    }
}
