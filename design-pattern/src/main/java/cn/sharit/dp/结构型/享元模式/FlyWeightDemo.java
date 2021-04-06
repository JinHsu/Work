package cn.sharit.dp.结构型.享元模式;

/**
 * <h2>享元模式</h2>
 * <p>享元模式通过共享技术实现相同或相似对象的重用提高系统资源的利用率。</p>
 * <p>享元模式是一个考虑系统性能的设计模式，通过使用享元模式可以节约内存空间，提高系统的性能。</p>
 * <p>享元模式的核心在于享元工厂类，享元工厂类的作用在于提供一个用于存储享元对象的享元池，用户需要对象时，首先从享元池中获取，如果享元池中不存在，则创建一个新的享元对象返回给用户，并在享元池中保存该新增对象。</p>
 */
public class FlyWeightDemo {

    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(127);
        Integer i2 = Integer.valueOf(127);
        Integer i3 = new Integer(127);
        Integer i4 = new Integer(127);
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i3 == i2);
        System.out.println("===============");
        // 元数据
        String s1 = new String("adc");
        String s2 = new String("adc");
        String s3 = "abc";
        String s4 = "abc";

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s3 == s2);
        System.out.println(s3 == s2.intern());

        System.out.println("=========java========");
        String s5 = "java";
        String s6 = new String("java");
        String intern = s5.intern();
        System.out.println(intern == s5);
        System.out.println(intern == intern.intern());
        System.out.println(s6.intern() == s5);

    }
}
