package com.idodevjobs.sample.service;



import org.springframework.stereotype.Service;

import com.idodevjobs.sample.model.ExampleModel;


//http://localhost:8181/rest-project/services/example/1
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
 

	    public ExampleModel get(String modelId) {
	        return new ExampleModel("myexample", 1001);
	    }
}