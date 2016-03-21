package com.mark43.hackathon;

import org.glassfish.grizzly.http.HttpRequestPacket;
import org.glassfish.grizzly.websockets.Broadcaster;
import org.glassfish.grizzly.websockets.DefaultWebSocket;
import org.glassfish.grizzly.websockets.ProtocolHandler;
import org.glassfish.grizzly.websockets.WebSocketListener;

/**
 * @author ari@mark43.com
 * @since 3/21/16
 */
public class HackathonSocket extends DefaultWebSocket {

    public HackathonSocket(ProtocolHandler protocolHandler, HttpRequestPacket request,
                           WebSocketListener... listeners)
    {
        super(protocolHandler, request, listeners);
    }
}
