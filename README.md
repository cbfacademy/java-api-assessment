# Java API Assessment

## Introduction
This assessment requires you to build a RESTful API, using all you've learned about software development using Java and Spring Boot.

You can build any API of your choosing, but it **must** include the following:

1. At least one GET endpoint that can have its results filtered using a Spring Data JPA query method (custom or derived)
2. Unit tests for at least one class
3. Data storage in a MySQL database
4. Exception handling
5. Evidence of inheritance
6. Good use of HTTP Protocols - methods, request and response, have full CRUD operations supported
7. Documentation

### Learning Outcomes

By the end of this assessment, you should be able to:

1. **Design and Architect APIs**: Get to grips with the nitty-gritty of curating a top-quality API, focusing on data flow and endpoint interactions.
1. **Implement Best Practices**: Showcase your adherence to Java and Spring Boot coding standards, error handling, and optimal project structure.
2. **Code Integration**: Seamlessly combine your custom code with the Spring Initializr project.
3. **Exception Management**: Efficiently handle exceptions, ensuring your API remains sturdy and dependable.

Onward with this assessment, you're set for a deep dive into API development with Java and Spring Boot.

## Design & Requirements

### Design Considerations
- **API Flow**: Map out your API's progression, from endpoints to their functionalities.

### Requirements List
- **Core**: Make use of Java and Spring Boot.
- **Endpoints**: Ensure they are detailed and fully operational.
- **Error Handling**: Your API should handle mishaps gracefully and return informative feedback.

### Learning Outcomes
- Acknowledge the pivotal role of a focused design in APIs.
- See firsthand how a detailed requirements list can pave the way for successful development.

## Repository Management

- **Consistent Commits**: Commit often, capturing your progress and thought process.
- **README**: Not just an afterthought. Fill it with the essence of your API, setup instructions, and other salient details.

### **Learning Outcomes:**
- Hone your skills in effective version control.
- Recognise the value of a well-curated repository.

## Code Quality & Structure

- **Best Practices**: Stick to Java and Spring Boot best practices and conventions.
- **Modularity**: Your code should be modular, reusable, and easily comprehensible.

#### Learning Outcomes
- Craft clean, efficient, and maintainable code.
- Harness Java and Spring Boot to the fullest.

---

## Getting Started

- [Prerequisites](#prerequisites)

- [Setup](#setup)

### Prerequisites

Before you begin, make sure you have the following installed:

1. [JDK 21](https://learn.microsoft.com/en-gb/java/openjdk/download#openjdk-21) (or higher)

2. [Git](https://git-scm.com/downloads)

3. [Visual Studio Code](https://code.visualstudio.com/Download)
   1. [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
   2. [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

Also make sure you have accounts for the following:

1. [GitHub](https://github.com/signup)

### Setup

1. Create a new repository on GitHub and clone it to your local machine.
2. Create a new Spring Boot project using [Spring Initializr](https://start.spring.io/). Choose the appropriate options for your project, such as the programming language, framework, and dependencies. Unzip the downloaded archive into your repository.
3. Implement the functionality of your API to fulfill the requirements.

## **Deliverables**

Ensure that your work is merged to the `main` branch of your GitHub repository by the specified deadline (original or extended). Your solution will assessed based on the state of that branch *at that point in time*; any feature branches or later commits will **not** be taken into account.

### Export Database

To ensure that your project can be assessed correctly, you **must** include a database dump file that can be used to restore a usable database and document the file's location in your `README.md` file.

You can generate a dump file using the command line or MySQL Workbench:

#### Command Line

Execute the following command to export the database:

```sh
mysqldump -u [username] -p --databases [database_name] > [dump_file.sql]
```

Replace `[username]`, `[database_name]`, and `[dump_file.sql]` with your MySQL username, the name of the database you want to dump, and the desired filename for the dump file, respectively. Remove the `-p` flag if you don't have a password set for your MySQL user.

#### MySQL Workbench

1. Open MySQL Workbench.
2. Connect to your MySQL server.
3. Go to the "Server" menu and select "Data Export".
4. Select the database you want to export:
   - In the "Data Export" tab, check the box next to the database you want to export.
5. Choose the Export Options:
   - Select "Dump Structure and Data" to include both the database schema and the data.
   - Choose "Export to Self-Contained File" and provide a filename for the dump file.
6. Include the Create Database Statement:
   - In the "Advanced Options" section, ensure that the "Add DROP DATABASE" and "Add CREATE DATABASE" options are checked. This ensures that the dump file will contain statements to drop and create the database.
7. Start the Export:
   - Click the "Start Export" button to generate the dump file.

## Top Tips

- :camera_flash: Commit frequently and use meaningful commit messages. A granular, well-labelled history becomes an increasingly valuable asset over time.
- :cactus: Use feature branches. Build the habit of isolating your changes for specific tasks and merging them into your default branch when complete.
- :vertical_traffic_light: Use consistent naming conventions. Choose easily understandable names and naming patterns for your classes, functions and variables.
- :triangular_ruler: Keep your code tidy. Using the built-in formatting of VS Code or other IDEs makes your code easier to read and mistakes easier to spot.
- :books: Read the docs. Whether via Intellisense in your IDE, or browsing online documentation, build a clear understanding of the libraries your code leverages.
- :calendar: Don't wait until the last minute. Plan your work early and make the most of the time available to complete the assessment and avoid pre-deadline palpitations.
- :sos: Ask. :clap: For. :clap: Help! :clap: Your mentors, instructors and assistants are literally here to support you, so *make use of them* - don't sit and struggle in silence.

Best of luck! Remember, it's not just about the destination; it's the journey. Happy coding! 🚀