package com.mark43.hackathon;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.websockets.WebSocketAddOn;
import org.glassfish.grizzly.websockets.WebSocketApplication;
import org.glassfish.grizzly.websockets.WebSocketEngine;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

/**
 * @author ari@mark43.com
 * @since 3/21/16
 */
public class App {

    public static void main(String[] args) {
        HttpServer server =
                GrizzlyHttpServerFactory.createHttpServer(URI.create("http://0.0.0.0:8081"), getResourceConfig());
        final WebSocketAddOn addon = new WebSocketAddOn();
        for (NetworkListener listener : server.getListeners()) {
            listener.registerAddOn(addon);
        }

        final WebSocketApplication chatApplication = new HackathonApplication();
        WebSocketEngine.getEngine().register("/chat", "/chat", chatApplication);

        System.out.println("Exposing app at: http://0.0.0.0:8081");
    }

    static ResourceConfig getResourceConfig() {
        ResourceConfig rc = new ResourceConfig().packages("com.mark43.hackathon");
        rc.register(JacksonFeature.class);
        return rc;
    }
}
