package cn.sharit;

public class Clinit {

    public static final int c = 20;

    static {
        a = 3;
        // System.out.println(a); // Illegal forward reference
    }

    private static int a = 2;

    public static void main(String[] args) {
        // write your code here
        System.out.println(a);
    }
}
