import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    private static Library library = new Library();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedDemoData();
        while (true) {
            printMainMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": addBookMenu(); break;
                case "2": listBooksMenu(); break;
                case "3": removeBookMenu(); break;
                case "4": addUserMenu(); break;
                case "5": listUsersMenu(); break;
                case "6": removeUserMenu(); break;
                case "7": issueBookMenu(); break;
                case "8": returnBookMenu(); break;
                case "9": System.out.println("Bye!"); sc.close(); return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== Library Management ===");
        System.out.println("1. Add Book");
        System.out.println("2. List Books");
        System.out.println("3. Remove Book");
        System.out.println("4. Add User");
        System.out.println("5. List Users");
        System.out.println("6. Remove User");
        System.out.println("7. Issue Book");
        System.out.println("8. Return Book");
        System.out.println("9. Exit");
        System.out.print("Choice: ");
    }

    private static void addBookMenu() {
        System.out.print("Title: "); String title = sc.nextLine().trim();
        System.out.print("Author: "); String author = sc.nextLine().trim();
        System.out.print("ISBN: "); String isbn = sc.nextLine().trim();
        Book b = library.addBook(title, author, isbn);
        System.out.println("Added: " + b);
    }

    private static void listBooksMenu() {
        List<Book> books = library.listBooks();
        if (books.isEmpty()) System.out.println("No books.");
        else books.forEach(System.out::println);
    }

    private static void removeBookMenu() {
        System.out.print("Book ID to remove: ");
        int id = parseIntInput();
        boolean ok = library.removeBook(id);
        System.out.println(ok ? "Removed." : "Failed to remove.");
    }

    private static void addUserMenu() {
        System.out.print("Name: "); String name = sc.nextLine().trim();
        System.out.print("Email: "); String email = sc.nextLine().trim();
        System.out.print("Role (STUDENT/TEACHER/STAFF): "); 
        String r = sc.nextLine().trim().toUpperCase();
        User.Role role;
        try { role = User.Role.valueOf(r); }
        catch (Exception e) { role = User.Role.STUDENT; }
        User u = library.addUser(name, email, role);
        System.out.println("Added: " + u);
    }

    private static void listUsersMenu() {
        List<User> users = library.listUsers();
        if (users.isEmpty()) System.out.println("No users.");
        else users.forEach(System.out::println);
    }

    private static void removeUserMenu() {
        System.out.print("User ID to remove: ");
        int id = parseIntInput();
        boolean ok = library.removeUser(id);
        System.out.println(ok ? "Removed." : "Failed to remove.");
    }

    private static void issueBookMenu() {
        System.out.print("Book ID: "); int bookId = parseIntInput();
        System.out.print("User ID: "); int userId = parseIntInput();
        boolean ok = library.issueBook(bookId, userId);
        System.out.println(ok ? "Book issued." : "Failed to issue.");
    }

    private static void returnBookMenu() {
        System.out.print("Book ID: "); int bookId = parseIntInput();
        System.out.print("User ID: "); int userId = parseIntInput();
        boolean ok = library.returnBook(bookId, userId);
        System.out.println(ok ? "Book returned." : "Failed to return.");
    }

    private static int parseIntInput() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void seedDemoData() {
        library.addBook("Clean Code", "Robert C. Martin", "9780132350884");
        library.addBook("Effective Java", "Joshua Bloch", "9780134685991");
        library.addUser("Alice", "alice@example.com", User.Role.STUDENT);
        library.addUser("Bob", "bob@example.com", User.Role.TEACHER);
    }
}

