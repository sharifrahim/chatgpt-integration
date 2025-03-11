# ChatGPT Structured Output Demo

This project demonstrates how to leverage the **Strategy Pattern** along with **Spring Boot** class mapping to easily implement structured output from ChatGPT. The approach allows you to generate and parse JSON responses from ChatGPT in a type-safe manner using custom DTOs and message strategies.

## Features

- **Structured Output via ChatGPT:**  
  Generate responses in a predefined JSON structure by instructing ChatGPT with system messages. The response is automatically mapped to your defined DTOs (e.g., `HadithOfTheDayDTO`, `IslamicEventDetailDTO`, `QuranOfTheDayDTO`) using the strategy pattern.

- **Strategy Pattern for Flexibility:**  
  Each ChatGPT request is encapsulated in a strategy class (e.g., `HadithOfTheDayStrategy`, `IslamicEvent`, `QuranOfTheDay`). This makes it easy to extend the system with additional structured outputs without changing the core logic.

- **Spring Boot Integration:**  
  The application is built with Spring Boot, making it easy to manage dependency injection, configuration, and RESTful endpoints.

- **Official OpenAI Java Library:**  
  This project uses the official [OpenAI Java library](https://github.com/openai/openai-java) to communicate with the ChatGPT API.

## Getting Started

### Prerequisites

- **Java 11 or higher**
- **Maven or Gradle**
- **Spring Boot 2.5+**

### Setup

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/sharifrahim/your-repo.git
   cd your-repo
   ```

2. **Generate your own ChatGPT API Key:**

   Sign up or log in to [OpenAI Platform](https://platform.openai.com/) and create your API key.

3. **Configure the API Key:**

   In your application's `application.properties` or `application.yml`, add the following property:

   ```properties
   openai.api.key=YOUR_OPENAI_API_KEY
   ```

4. **Build and Run the Application:**

   Using Maven:
   ```bash
   mvn spring-boot:run
   ```

   Or using Gradle:
   ```bash
   ./gradlew bootRun
   ```

## How It Works

### ChatGPT Structured Output

The core of this implementation is the **ChatGptServiceImpl** class. It:
- Generates an expected JSON format using an empty instance of the response DTO.
- Constructs the API request with a system message instructing ChatGPT to output a JSON in the specified format.
- Calls the ChatGPT API using the official OpenAI Java client.
- Processes and deserializes the JSON response into the respective DTO.

This approach allows for:
- **Strongly Typed Responses:**  
  By using Spring Boot’s class mapping and DTOs, responses from ChatGPT are automatically converted into Java objects.
- **Easy Extensibility:**  
  By leveraging the **MessageStrategy** interface, adding a new structured output is as simple as creating a new strategy implementation.

### Example Strategy Implementations

- **Hadith of the Day:**  
  `HadithOfTheDayStrategy` generates a user message like _"Give me random islamic hadith"_ and expects a `HadithOfTheDayDTO` as the response.

- **Islamic Event Details:**  
  `IslamicEvent` takes an event name as input and constructs a message requesting details about the event's origin and sunnah, formatted as a paragraph with reference links. The response is mapped to an `IslamicEventDetailDTO`.

- **Quran of the Day:**  
  `QuranOfTheDay` requests a random Quran verse and maps the output to a `QuranOfTheDayDTO`.

## Technologies Used

- **Spring Boot:** For rapid application development and dependency management.
- **Official OpenAI Java Library:** To interact with ChatGPT via the OpenAI API.  
  [OpenAI Java Library](https://github.com/openai/openai-java)
- **Lombok:** To reduce boilerplate code for DTOs and services.
- **Jackson:** For JSON processing and deserialization.

## Contributing

Contributions are welcome! Please open issues or submit pull requests for any improvements or bug fixes.

---

**Author:** [sharifrahim](https://github.com/sharifrahim)

Generate your own ChatGPT API key at [OpenAI Platform](https://platform.openai.com/).

Enjoy building structured outputs with ease!
