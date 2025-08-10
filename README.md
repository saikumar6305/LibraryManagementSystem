# Library Management System (Java OOP)

This is a **Java Console-based Library Management System** developed as part of the **Java Developer Internship - Task 3**.  
It demonstrates **Object-Oriented Programming (OOP)** concepts: **Abstraction, Inheritance, Polymorphism, Encapsulation**.

---

## Features
- **Book Management** (Add, List, Remove)
- **User Management** (Add, List, Remove)
- **Issue & Return Books**
- Prevents deleting:
  - Issued books
  - Users with borrowed books
- Uses **multi-class structure** with abstraction & interfaces
- Fully runs in **command-line (CLI)**

---

## Technologies Used
- Java 17
- VS Code
- Command-line execution

---

## Project Structure
LibraryManagement/
├── Book.java # Book class
├── Person.java # Abstract Person class
├── User.java # User class (extends Person)
├── LibraryOperations.java # Interface for library actions
├── Library.java # Implements LibraryOperations
├── LibraryCLI.java # Main CLI program
└── README.md # Project documentation

---

## OOP Concepts Demonstrated
| Concept        | Example in Code |
|----------------|-----------------|
| **Abstraction** | `Person` (abstract class), `LibraryOperations` (interface) |
| **Inheritance** | `User` extends `Person` |
| **Polymorphism** | `Library` implementing `LibraryOperations` |
| **Encapsulation** | Private fields with getters/setters in all classes |

---

## How to Run
### **1. Clone the repository**
```bash
git clone <your-repo-url>
cd LibraryManagement
 
---

Compile
   javac *.java

Run
   java LibraryCLI

---
## Code Running
=== Library Management ===
1. Add Book
2. List Books
3. Remove Book
4. Add User
5. List Users
6. Remove User
7. Issue Book
8. Return Book
9. Exit
Choice:



