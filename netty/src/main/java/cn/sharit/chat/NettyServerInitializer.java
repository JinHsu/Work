package cn.sharit.chat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
//                .addLast(new StringDecoder()) // 入站处理器
//                .addLast(new StringEncoder()) // 出站处理器
                .addLast(new MessageDecoder())
                .addLast(new NettyServerHandler());
    }

}
