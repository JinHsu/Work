package cn.sharit.chat;

import java.io.Serializable;

public class MessageProtocol implements Serializable {
    int len;
    byte[] data;

    public MessageProtocol(int len, byte[] data) {
        this.len = len;
        this.data = data;
    }
}
