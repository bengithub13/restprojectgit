package com.idodevjobs.sample.service;

import javax.ws.rs.PathParam;

import org.springframework.stereotype.Service;

import com.idodevjobs.sample.model.ExampleModel;


//http://localhost:8181/spring-cxf-rest-example/services/example/1
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
 

	    public ExampleModel get(String modelId) {
	        return new ExampleModel("example", 1001);
	    }
}