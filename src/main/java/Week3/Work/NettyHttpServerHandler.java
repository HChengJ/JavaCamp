package Week3.Work;

import Week3.NIO_Gateway.filter.HeaderHttpRequestFilter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.Headers;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;
import okhttp3.internal.http2.Header;


public class NettyHttpServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){ctx.flush();}

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        try {
            FullHttpRequest fullRequest = ( FullHttpRequest) msg;
            //自定义头文件校验字段
            if(StringUtil.isNullOrEmpty(fullRequest.headers().get("word_key"))){
                illegalHandler(fullRequest,ctx);
                return;
            }
            String uri = fullRequest.uri();
            if (uri.contains("/test")) {
                handlerTest(fullRequest, ctx);
            }
        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private void handlerTest(FullHttpRequest fullRequest,ChannelHandlerContext ctx){
        FullHttpResponse response = null;
        try{
            String value = "Hello,This is NettyHttpServerHandler";
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK, Unpooled.wrappedBuffer(value.getBytes()));
            response.headers().set("Content_Type","application/json");
            response.headers().setInt("Content-Length",response.content().readableBytes());
        }catch (Exception e){
            System.out.println("处理测试接口出错"+e.toString());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        }finally {
            if(fullRequest != null){
                if(!HttpUtil.isKeepAlive(fullRequest)){
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                }else {
                    response.headers().set("Connection","keep-alive");
                    ctx.write(response);
                }
            }
        }
    }

    private void illegalHandler(FullHttpRequest fullRequest,ChannelHandlerContext ctx){
        FullHttpResponse response = null;
        try{
            String value = "Hello,Please use word_key";
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK, Unpooled.wrappedBuffer(value.getBytes()));
            response.headers().set("Content_Type","application/json");
            response.headers().setInt("Content-Length",response.content().readableBytes());
        }catch (Exception e){
            System.out.println("处理测试接口出错"+e.toString());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        }finally {
            if(fullRequest != null){
                if(!HttpUtil.isKeepAlive(fullRequest)){
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                }else {
                    response.headers().set("Connection","keep-alive");
                    ctx.write(response);
                }
            }
        }
    }

}