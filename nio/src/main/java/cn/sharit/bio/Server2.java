package cn.sharit.bio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        while (true) {
            System.out.println("接受消息中...");
            Socket socket = ss.accept(); // 阻塞
            new Thread(new T(socket)).start();
        }
    }

}

class T implements Runnable {
    Socket socket;

    public T(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = is.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len);
            }
            System.out.println("接受到消息：" + new String(baos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
