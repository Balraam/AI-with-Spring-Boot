# **Chatbot Project**

## **Overview**
This project is an AI-based chatbot built using Spring Boot. It leverages the [Ollama](https://ollama.ai/) API to process and respond to user queries in natural language.

---

## **Features**
- **Spring Boot Backend:** Reliable and scalable backend built with Spring Boot.
- **Ollama API Integration:** Seamless integration with Ollama API for intelligent conversational AI.
- **RESTful APIs:** Simple and efficient RESTful endpoints for communication.

---

## **Prerequisites**
1. **Java 8 or later**
2. **Spring Boot 3.x**
3. Maven(Build Tool)
4. [Ollama API Key](https://ollama.ai/)
5. IDE (STS)

---

## **Installation**

### Step 1: Clone the Repository
```bash
git clone https://github.com/username/repository-name.git
cd repository-name
```

### Step 2: Install Dependencies
For Maven:
```bash
mvn clean install
```

### Step 3: Configure Environment Variables
Set your Ollama API Key in the `application.properties` file:
```properties
ollama.api.key=your_api_key_here
server.port=8080
```

### Step 4: Run the Application
```bash
mvn spring-boot:run
```

---

## **Usage**

### Access the Application
1. Open your browser and navigate to:
   `http://localhost:8080`

### Page will Open
#### Enter the Prompt and click on generate
![image](https://github.com/user-attachments/assets/3a15f0d4-de2d-4ead-9af2-3c5a44226c74)

- **Response:**
 ``` 
"Hi! How can I assist you today?"

```

---

## **Folder Structure**
```
src/
├── main/
│   ├── java/com/springboot/ai/    # Source code
│   │   ├── controller/            # REST Controllers
│   │   ├── service/               # Service Layer
│   │   ├── dto/                   # DTO
│   ├── resources/
│       ├── application.properties # Spring Boot properties
│       └── static/                # Static files 
└── test/                          # Unit and Integration tests
```

---

## **Setting Up Ollama**

1. **Download Ollama**
   - Visit the [Ollama Downloads Page](https://ollama.ai/downloads) and download the appropriate version for your operating system (Windows, macOS, or Linux).

5. **Test Ollama API Locally**
   - Use a test prompt to ensure Ollama API is responding:
     ```bash
     curl -X POST http://localhost:11434/api/v1/chat \
          -H "Authorization: Bearer <OLLAMA_API_KEY>" \
          -H "Content-Type: application/json" \
          -d '{"model": "chatbot-model-name", "prompt": "Hello, Ollama!"}'
     ```
   - Expected Response:
     ```json
     {
       "id": "unique-session-id",
       "response": "Hello! How can I assist you?"
     }
     ```

