package com.springboot.ai.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    
	@Autowired
	private OllamaChatModel chatModel;
	
	
	public String generatePrompt(String prompt) {
	    try {
	        // Create a new Prompt object with the provided prompt
	        Prompt generatedPrompt = new Prompt(
	            prompt, 
	            OllamaOptions.create().withModel(OllamaModel.LLAMA3_2_1B)
	        );
	        
	        // Call the chat model
	        ChatResponse response = chatModel.call(generatedPrompt);
	        
	        // Validate response and extract content
	        if (response != null && 
	            response.getResult() != null && 
	            response.getResult().getOutput() != null) {
	            
	            return response.getResult().getOutput().getContent();
	        } else {
	            throw new IllegalStateException("Invalid response from chat model.");
	        }
	    } catch (Exception e) {
	        // Log or handle the exception
	        System.err.println("Error generating prompt: " + e.getMessage());
	        return "An error occurred while generating the prompt.";
	    }
	}
	
}
