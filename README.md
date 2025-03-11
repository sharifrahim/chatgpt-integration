# ChatGPT Integration

This project demonstrates how to integrate ChatGPT into a Java application using Spring Boot. It leverages the official OpenAI Java library to communicate with the ChatGPT API and implements a structured output approach. By using a Strategy design pattern together with Spring Boot’s class mapping features, the application easily converts raw ChatGPT responses into a well-defined data structure.

## Table of Contents
1. [Overview](#overview)  
2. [Features](#features)  
3. [Prerequisites](#prerequisites)  
4. [Installation](#installation)  
5. [Configuration](#configuration)  
6. [Usage](#usage)  
7. [Structured Output Implementation](#structured-output-implementation)  
8. [Additional Resources](#additional-resources)  
9. [Project Structure](#project-structure)  
10. [License](#license)  
11. [Contributing](#contributing)

---

## Overview
This repository showcases how to integrate ChatGPT into a Spring Boot application using the official OpenAI Java library. The project connects to the ChatGPT API, sends prompts, and receives structured responses by leveraging a Strategy design pattern. This design simplifies the transformation of raw responses into a consistent and well-organized format.

---

## Features
- **OpenAI ChatGPT API Integration:** Connect to the ChatGPT API using the official [OpenAI Java library](https://github.com/openai/openai-java).  
- **Structured Output:** Transform raw responses into a consistent data structure using a Strategy design pattern and Spring Boot’s mapping capabilities.  
- **Flexibility:** Easily switch or update the response transformation logic without impacting the rest of the application.  
- **Spring Boot Integration:** Benefit from Spring Boot’s robust configuration and dependency management.

---

## Prerequisites
- **Java 8+**
- **Maven 3+**
- **OpenAI API Key:** Generate your own ChatGPT API key at [https://platform.openai.com/](https://platform.openai.com/).

---

## Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/sharifrahim/chatgpt-integration.git
   ```
2. **Navigate into the project folder:**
   ```bash
   cd chatgpt-integration
   ```
3. **Build the project:**
   ```bash
   mvn clean install
   ```
   This command downloads dependencies (including the official OpenAI Java library) and compiles the project.

---

## Configuration
1. **Set your OpenAI API Key:**  
   You can configure your API key using one of the following methods:
   - **Environment Variable:**
     ```bash
     export OPENAI_API_KEY="your_api_key_here"
     ```
   - **Configuration File (e.g., `application.properties`):**
     ```properties
     openai.api.key=your_api_key_here
     ```
   - **Java System Property:**
     ```bash
     mvn clean install -Dopenai.api.key="your_api_key_here"
     ```
2. **Additional Settings:**  
   Configure other settings such as model type (e.g., `gpt-3.5-turbo`), temperature, or maximum tokens as needed within your configuration files.

---

## Usage
1. **Run the Application:**  
   For a Spring Boot application, run:
   ```bash
   mvn spring-boot:run
   ```
   or run the packaged JAR:
   ```bash
   java -jar target/chatgpt-integration-demo.jar
   ```
2. **Send a Request:**  
   Use a REST client or command-line tool (like `curl`) to send prompts to the API endpoint:
   ```bash
   curl -X POST -H "Content-Type: application/json" \
       -d '{"prompt": "Hello ChatGPT!"}' \
       http://localhost:8080/api/chat
   ```
3. **View the Structured Response:**  
   The application returns responses in a structured format according to your defined data model.

---

## Structured Output Implementation
The project ensures that ChatGPT responses are returned in a structured format. By leveraging a Strategy design pattern alongside Spring Boot’s class mapping features, the application can easily convert raw responses into a consistent data structure. This approach allows for flexible and maintainable transformation logic without impacting other parts of the application.

---

## Additional Resources
- **Generate Your Own API Key:**  
  Get started by generating your ChatGPT API key at [https://platform.openai.com/](https://platform.openai.com/).
- **Official OpenAI Java Library:**  
  For detailed documentation on the library, visit [https://github.com/openai/openai-java](https://github.com/openai/openai-java).

---

## Project Structure
A typical project layout might look like this:
```
chatgpt-integration
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com.example.chatgpt
│       │       ├── Application.java
│       │       ├── service
│       │       │   └── ChatGPTService.java
│       │       └── strategy
│       │           └── [Your Strategy Classes]
│       └── resources
│           └── application.properties
└── README.md
```

---

## License
This project is released under the [MIT License](LICENSE). Feel free to modify and distribute it as needed.

---

## Contributing
Contributions, issues, and feature requests are welcome. Please open an issue or submit a pull request to discuss any improvements.

---

**Enjoy integrating ChatGPT into your Java application!**  
If you have any questions or suggestions, please open an issue or reach out.

---
