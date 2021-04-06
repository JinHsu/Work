package cn.sharit.dp.结构型.装饰模式;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <h2>装饰者模式</h2>
 * <p>装饰模式：被装饰的对象在运行时确定</p>
 * <p>代理模式：被代理的对象在编译时确定</p>
 */
public class DecoratorDemo {

    public static void main(String[] args) throws Exception {
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 55));
        userList.add(new User("李四", 12));
        userList.add(new User("王五", 25));
        userList.add(new User("qiqi", 32));
        userList.add(new User("hao", 33));

        Sorter sorter = new AgeSorter();
        NameSorter nameSorter = new NameSorter(sorter);
        nameSorter.sort(userList);
        System.out.println(Arrays.toString(userList.toArray()));


        // JDK IO流
        FileInputStream fis = new FileInputStream(new File(""));
        ByteArrayInputStream bais = new ByteArrayInputStream("".getBytes());

    }

}

class AgeSorter implements Sorter {

    @Override
    public void sort(List<User> userList) {
        userList.sort(Comparator.comparingInt(User::getAge));
    }
}

class NameSorter extends SorterDecorator {

    public NameSorter(Sorter sorter) {
        super(sorter);
    }

    @Override
    public void sort(List<User> userList) {
        userList.sort(Comparator.comparing(User::getName));
        super.sort(userList);
    }
}

abstract class SorterDecorator implements Sorter {

    private final Sorter sorter;

    public SorterDecorator(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public void sort(List<User> userList) {
        sorter.sort(userList);
    }

    public Sorter getSorter() {
        return sorter;
    }
}


interface Sorter {

    void sort(List<User> userList);

}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
