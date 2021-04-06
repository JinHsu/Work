package cn.sharit.chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    int readCount;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyClientHandler.channelActive");
//        String msg = "您好，服务器";
//        ctx.writeAndFlush(msg);
        // 粘包拆包
        for (int i = 0; i < 15; i++) {
            String msg = "您好，服务器" + "[" + i + "]\n";
//            ByteBuf byteBuf = Unpooled.copiedBuffer(msg.getBytes(CharsetUtil.UTF_8));
            byte[] bytes = msg.getBytes(CharsetUtil.UTF_8);
            ctx.writeAndFlush(new MessageProtocol(bytes.length, bytes));
        }


    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyClientHandler.channelRead");
//        System.out.println(msg);
//        System.out.println("readCount=" + ++readCount);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyClientHandler.channelReadComplete");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("[" + System.currentTimeMillis() + "] " + "NettyClientHandler.exceptionCaught");
    }
}
