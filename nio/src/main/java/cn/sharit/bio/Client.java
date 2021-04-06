package cn.sharit.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        while (true) {
            Socket socket = new Socket("127.0.0.1", 8888);
            System.out.println("请输入消息：");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            OutputStream os = socket.getOutputStream();
            os.write(line.getBytes());
            os.flush();
            os.close();
        }
    }

}
