package cn.sharit.dp.创建型.原型模式;

/**
 * 原型模式
 * <p>Spring中Bean的scope</p>
 */
public class PrototypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep("多利", 3);
        System.out.println(sheep);
        Sheep sheep2 = (Sheep) sheep.clone();
        System.out.println(sheep2);
    }

}
