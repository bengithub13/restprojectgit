package com.idodevjobs.sample.service;
import com.idodevjobs.sample.model.ExampleModel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 

//http://localhost:8181/rest-project/services/example/1
@Path("/example")
@Produces("application/json")
public interface ExampleService {
 
    @GET
    @Path("/{id}")
    public ExampleModel get(@PathParam("id") String id);
 
}
