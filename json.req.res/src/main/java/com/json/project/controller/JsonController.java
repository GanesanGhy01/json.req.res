package com.json.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.json.project.request.JsonRequest;
import com.json.project.response.JsonResponse;
import com.json.project.service.JsonService;

@RestController
public class JsonController {
	
	@Autowired
	JsonService service;
	
	@PostMapping("saveJson")
	public JsonResponse saveJson(@RequestBody JsonRequest jsonreq) throws IOException {
		
		return service.insertJson(jsonreq);
	}
}
