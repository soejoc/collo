package io.jochimsen.collo.handler.outbound;

import io.jochimsen.collo.protocol.Version;
import io.jochimsen.collo.stream.ProtocolOutputStream;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class SerializedProtocolMessageEncoder extends MessageToByteEncoder<RawProtocolMessageOutput> {
    @Override
    protected void encode(final ChannelHandlerContext ctx, final RawProtocolMessageOutput msg, final ByteBuf out) {
        out.writeInt(Version.PROTOCOL_VERSION);

        final int messageId = msg.getMessageId();
        out.writeInt(messageId);

        final ProtocolOutputStream protocolStream = msg.getProtocolOutputStream();
        final byte[] buffer = protocolStream.getBuffer();
        final int messageLength = buffer.length;

        out.writeInt(messageLength);
        out.writeBytes(buffer, 0, messageLength);
    }
}
