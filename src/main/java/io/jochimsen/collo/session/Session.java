package io.jochimsen.collo.session;

import io.jochimsen.collo.exception.ProtocolMessageSerializationException;
import io.jochimsen.collo.exception.session.InactiveChannelContextException;
import io.jochimsen.collo.handler.outbound.RawProtocolMessageOutput;
import io.jochimsen.collo.protocol.ErrorMessage;
import io.jochimsen.collo.protocol.ProtocolMessage;
import io.jochimsen.collo.stream.ProtocolOutputStream;
import io.netty.channel.ChannelHandlerContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@AllArgsConstructor
public abstract class Session<M extends ProtocolMessage> {

    @Getter
    @Setter
    protected ChannelHandlerContext channelHandlerContext;

    public void close() {
        channelHandlerContext.close();
    }

    private void sayActual(final ProtocolMessage protocolMessage) {
        if(protocolMessage == null) {
            throw new NullPointerException("protocolMessage is null!");
        }

        if(!isActive()) {
            throw new InactiveChannelContextException();
        }

        try {
            final int messageId = protocolMessage.getMessageId();
            final ProtocolOutputStream protocolOutputStream = new ProtocolOutputStream();
            protocolOutputStream.write(protocolMessage);
            protocolOutputStream.flush();

            channelHandlerContext.writeAndFlush(new RawProtocolMessageOutput(messageId, protocolOutputStream));
        } catch (final IOException e) {
            throw new ProtocolMessageSerializationException(e);
        }
    }

    public void say(final M message) {
        sayActual(message);
    }

    public void say(final ErrorMessage errorMessage) {
        sayActual(errorMessage);
    }

    public void onClose() {
        channelHandlerContext = null;
    }

    public boolean isActive() {
        return channelHandlerContext != null && !channelHandlerContext.isRemoved();
    }
}
