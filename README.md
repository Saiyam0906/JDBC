JDBC Practice with Two SQL Databases: Normal and Transactional Operations

This repository contains Java-based JDBC (Java Database Connectivity) practice code that interacts with two SQL databases:

     db: A standard database used for demonstrating basic CRUD (Create, Read, Update, Delete) operations.
    trans: A database used for demonstrating transaction management, including commit, rollback, and handling ACID properties in JDBC.

Key Features:

    Database Connection Handling: Establishes connections to two different databases using JDBC.
    CRUD Operations: Implements basic SQL operations (INSERT, SELECT, UPDATE, DELETE) in the db database.
    Transaction Management: Demonstrates how to handle transactions in JDBC using the trans database, with support     for commits and rollbacks.
    Error Handling: Utilizes try-catch blocks for proper error handling during database operations.
    Prepared Statements: Ensures secure database interaction by using prepared statements to prevent SQL injection attacks.

Technologies Used:

    Java: Core Java concepts with JDBC for database interaction.
    SQL: Structured Query Language for managing relational data in the databases.
    JDBC API: For establishing connections and executing SQL statements.
    MySQL (a relational database): Can be used as the backend database.

How to Use:

    Clone the repository.
    Configure the db and trans database connection details in the provided configuration file (db.properties).
    Run the Java code to perform both normal database operations and transactional operations with proper 
    exception handling.
