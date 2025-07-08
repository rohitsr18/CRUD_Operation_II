# CRUD Application using Hibernate

This project demonstrates basic CRUD (Create, Read, Update, Delete) operations on a `Student` entity using Hibernate ORM with a PostgreSQL database.

## Features

- Add, view, update, and delete student records
- Console-based Java application
- Uses Hibernate for ORM

## Technologies

- Java
- Hibernate ORM
- PostgreSQL
- Maven

## Getting Started

1. **Clone the repository**

2. **Set up PostgreSQL**
   - Create a database named `sample`.
   - Update the database credentials in `src/main/resources/hibernate.cfg.xml` if needed.

3. **Build the project**

   ```sh
   mvn clean package
   ```

4. **Run the application**

   ```sh
   mvn exec:java -Dexec.mainClass="com.rohitsr18.Main"
   ```

## Project Structure

- `src/main/java/com/rohitsr18/Student.java` - Student entity
- `src/main/java/com/rohitsr18/Main.java` - Main application logic
- `src/main/resources/hibernate.cfg.xml` - Hibernate configuration

## License

For educational use.
