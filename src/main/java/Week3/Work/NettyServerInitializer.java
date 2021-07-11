package Week3.Work;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        pipeline.addLast( new HttpObjectAggregator(65536));
        pipeline.addLast("MyTestHttpServerHandler", new NettyHttpServerHandler());
        System.out.println("initChannel_ok");
    }
}