import java.util.List;

public interface LibraryOperations {
    Book addBook(String title, String author, String isbn);
    boolean removeBook(int bookId);
    List<Book> listBooks();

    User addUser(String name, String email, User.Role role);
    boolean removeUser(int userId);
    List<User> listUsers();

    boolean issueBook(int bookId, int userId);
    boolean returnBook(int bookId, int userId);
}

