package io.jochimsen.collo.message;

import io.jochimsen.collo.protocol.ProtocolMessage;
import io.jochimsen.collo.session.Session;

public interface MessageHandlerFactory<M extends ProtocolMessage, S extends Session> {
    MessageHandler<? extends M, S> create(final Class<? extends MessageHandler<? extends M, S>> clazz);
}
