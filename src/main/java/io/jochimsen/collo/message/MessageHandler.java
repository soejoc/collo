package io.jochimsen.collo.message;

import io.jochimsen.collo.protocol.ProtocolMessage;
import io.jochimsen.collo.session.Session;

public interface MessageHandler<M extends ProtocolMessage, S extends Session> {
    void handleMessage(final M protocolMessage, final S session);
}
