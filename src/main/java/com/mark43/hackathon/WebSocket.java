package com.mark43.hackathon;

import org.glassfish.grizzly.http.HttpRequestPacket;
import org.glassfish.grizzly.websockets.*;

/**
 * @author ari@mark43.com
 * @since 3/21/16
 */
public class WebSocket extends DefaultWebSocket {

    public WebSocket(ProtocolHandler protocolHandler, HttpRequestPacket request,
                           WebSocketListener... listeners)
    {
        super(protocolHandler, request, listeners);
    }

    @Override
    protected void setBroadcaster(Broadcaster broadcaster) {
        this.broadcaster = broadcaster;
    }
}
