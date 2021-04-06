package cn.sharit.dp.创建型.原型模式;

public class Sheep implements Cloneable {
    String name;
    Integer age;

    public Sheep(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 深拷贝 序列化反序列化
        return super.clone(); // 浅拷贝
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "} @" + hashCode();
    }
}
