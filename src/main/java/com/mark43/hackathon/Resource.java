package com.mark43.hackathon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ari@mark43.com
 * @since 3/21/16
 */
@Path("/")
public class Resource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
        return "hello world";
    }

}
