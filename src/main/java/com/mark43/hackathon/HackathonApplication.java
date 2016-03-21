package com.mark43.hackathon;

import org.glassfish.grizzly.http.HttpRequestPacket;
import org.glassfish.grizzly.utils.DataStructures;
import org.glassfish.grizzly.websockets.*;
import org.glassfish.grizzly.websockets.WebSocket;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.Set;

/**
 * @author ari@mark43.com
 * @since 3/21/16
 */
public class HackathonApplication extends WebSocketApplication {

    private final Broadcaster broadcaster = new OptimizedBroadcaster();

    private Set<WebSocket> members = Collections.newSetFromMap(
            DataStructures.<WebSocket, Boolean>getConcurrentMap());

    @Override
    public org.glassfish.grizzly.websockets.WebSocket createSocket(ProtocolHandler handler,
                                                                   HttpRequestPacket requestPacket,
                                                                   WebSocketListener... listeners) {
        return new HackathonSocket(handler, requestPacket, listeners);
    }


    @Override
    public void onMessage(WebSocket socket, String data) {
        System.out.println(data);
        broadcaster.broadcast(members, data);
    }

    @Override
    public void onClose(WebSocket socket, DataFrame frame) {
        members.remove(socket);
        broadcaster.broadcast(members, "someone left the chat");
    }
}
