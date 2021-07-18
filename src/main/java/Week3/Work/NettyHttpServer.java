package Week3.Work;

import Week3.NIO_Gateway.inbound.HttpInboundServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Arrays;

public class NettyHttpServer {

    public static void main(String[] args) throws Exception {
//        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
//        EventLoopGroup workerGroup = new NioEventLoopGroup(10);
//        try {
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new NettyServerInitializer());
//            ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();
//            System.out.println("server is ok");
//            channelFuture.channel().closeFuture().sync();
//        } finally {
//            bossGroup.shutdownGracefully();
//            workerGroup.shutdownGracefully();
//        }

        String proxyPort = System.getProperty("proxyPort","9000");
        String proxyServers = System.getProperty("proxyServers","http://localhost:9001,http://localhost:9002");
        int port = Integer.parseInt(proxyPort);
        NettyInboundServer server = new NettyInboundServer(port, Arrays.asList(proxyServers.split(",")));
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}