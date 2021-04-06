package cn.sharit.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    int readCount;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyServerHandler.channelActive");
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyServerHandler.channelRead");
        MessageProtocol byteBuf = (MessageProtocol) msg;
        System.out.println(new String(byteBuf.data, CharsetUtil.UTF_8));
//        System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("readCount=" + ++readCount);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyServerHandler.channelReadComplete");
        // 回写消息给客户端
//        String msg = "您好，客户端";
//        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
