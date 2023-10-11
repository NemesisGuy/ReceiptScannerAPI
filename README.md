# Receipt Scanner API

**Receipt Data Processor System**


![](https://img.shields.io/badge/Spring_boot_3-blueviolet?style=for-the-badge)
![](https://img.shields.io/badge/Java_17-yellow?style=for-the-badge)


# Contributors:

    Peter Buckingham 

# Project Description:

The Receipt Data Processor API is a Spring Boot application that processes text files
using regular expressions to extract receipt data. 

The extracted data is processed using regular expressions (regex) to retrieve specific information, 
which is subsequently saved to a database. Additionally, the processed files can be moved to a designated folder after being processed.

**Usage:**

**Process Files** 

Endpoint: /process/files/default/regex


****Description:****

Processes files in the inputdata folder, applies regex processing, and stores the data in the database.

*Example Request:* 
http://localhost:9000/process/files/default/regex

*Response:*
Returns processed data in JSON format.

**Store Raw Data**

Endpoint: /store/raw/data/files

**Description:** 

Stores the raw data from the files in the database with their respective file names.
*Example Request:* 
http://localhost:9000/store/raw/data/files

Response: json upon storing raw data.

**Move Files**

**Endpoint:** /move/files
**Description:** Moves files from the input folder to the processed folder.
(These paths can be configured in application.properties)

# Getting Started

- Clone the repository.
- Set up the necessary configurations in application.properties.
- Build and run the application.

**Requirements**

- Java 11 or higher
- Spring Boot 
- Database (MySQL)

 # ****Configuration:****

- application.properties: Configure database connection, and file paths.
- pom.xml: Configure dependencies.


**Project Structure:**


- **src/main/java/za.co.vsoftsystems:** Contains the source code.
- **controller:** Controllers for handling HTTP requests.
- **service:** Services for processing files and applying regex.
- **domain:** Contains the ReceiptData entity.
- **src/main/resources:** Contains application properties and static resources.
- **src/data/inputdata:** Contains test data.
- **src/data/outputdata/processed:** Contains processed data. 


## Design Choices and Patterns:

### Domain-Driven Design (DDD)

The project follows the principles of Domain-Driven Design (DDD) to organize the codebase around the core business logic. Key DDD concepts applied include:

- **Entities:** Entities are objects that have an identity and are tracked through their lifecycle.

- **Services:** Services are used to encapsulate business logic that doesn't fit into a domain object.

- **Repositories:** Repositories are employed to abstract the data access layer and provide a clean interface for working with domain objects.

- **Value Objects:** Value objects represent concepts that don't have an identity, and are used for their attributes.

- **Factories: (to be implemented) ** Factories are used to encapsulate the logic for creating complex objects.

### Repository Pattern

The repository pattern is utilized to separate the logic that retrieves data from the database from the business logic. This promotes a cleaner and more maintainable codebase.

### Builder Pattern

The Builder pattern is employed for creating complex objects, such as `ReceiptData`, in a step-by-step manner. This improves the readability of object instantiation and allows for flexible construction.

### Factory Pattern - (to be implemented)

The Factory pattern is used to create objects without exposing the instantiation logic to the client. This allows for the creation of different types of objects without the need to change the client code.
