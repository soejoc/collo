package io.jochimsen.collo.message;

import io.jochimsen.collo.protocol.ProtocolMessage;
import io.jochimsen.collo.session.Session;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface MessageMapper<M extends ProtocolMessage, S extends Session> {
    Pair<M, S> map(final int messageId);

    @RequiredArgsConstructor
    @Getter
    class Pair<M extends ProtocolMessage, S extends Session> {
        private final Class<? extends M> messageClass;
        private final Class<? extends MessageHandler<? extends M, S>> messageHandlerClass;
    }
}
