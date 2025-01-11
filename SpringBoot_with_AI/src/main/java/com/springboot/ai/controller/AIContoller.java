package com.springboot.ai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.ai.dto.GenerateRequest;
import com.springboot.ai.service.AIService;

@RestController
public class AIContoller {
	
	@Autowired
	private AIService service;
	
//	@PostMapping("/api/v1/generate")
//	public String generage(@RequestBody String promptMessage) {
//		return service.generatePrompt(promptMessage);
//	}

	@PostMapping("/api/v1/generate")
    public ResponseEntity<String> generate(@RequestBody GenerateRequest request) {
        String promptMessage = request.getPromptMessage();

        // Validate the input
        if (promptMessage == null || promptMessage.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("promptMessage cannot be null or empty");
        }

        try {
            // Call the service layer
            String result = service.generatePrompt(promptMessage);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // Handle errors gracefully
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error generating response: " + e.getMessage());
        }
    }
}
