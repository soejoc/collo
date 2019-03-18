package io.jochimsen.collo.initializer;

import io.jochimsen.collo.handler.inbound.InboundHandlerBase;
import io.jochimsen.collo.handler.inbound.SerializedProtocolMessageDecoder;
import io.jochimsen.collo.handler.outbound.SerializedProtocolMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProtocolMessageChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final InboundHandlerBase inboundHandlerBase;

    @Override
    public void initChannel(final SocketChannel ch) throws Exception {
        final ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast(new SerializedProtocolMessageDecoder());
        channelPipeline.addLast(new SerializedProtocolMessageEncoder());
        channelPipeline.addLast(inboundHandlerBase);
    }
}
