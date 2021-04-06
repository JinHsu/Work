package cn.sharit.test;

public class Test {

    public static void main(String[] args) {

        String key = "徐进";
        int h = key.hashCode();
        System.out.println("hash=" + h);

        // rehash
        int hash;
        hash = ((hash = key.hashCode()) ^ (hash >>> 16));
        System.out.println("rehash=" + hash);

        int lenth = 64;
        System.out.println(h % lenth);
        System.out.println(h & (lenth - 1));
        System.out.println(hash & (lenth - 1));


        System.out.println(Integer.toBinaryString(h));
        System.out.println(Integer.toBinaryString(lenth - 1));

    }

}
