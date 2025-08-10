import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library implements LibraryOperations {
    private List<Book> books;
    private List<User> users;
    private int nextBookId;
    private int nextUserId;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        nextBookId = 1;
        nextUserId = 1;
    }

    @Override
    public Book addBook(String title, String author, String isbn) {
        Book b = new Book(nextBookId++, title, author, isbn);
        books.add(b);
        return b;
    }

    @Override
    public boolean removeBook(int bookId) {
        Optional<Book> book = findBook(bookId);
        if (book.isPresent()) {
            if (book.get().isIssued()) return false;
            books.remove(book.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Book> listBooks() {
        return new ArrayList<>(books);
    }

    @Override
    public User addUser(String name, String email, User.Role role) {
        User u = new User(nextUserId++, name, email, role);
        users.add(u);
        return u;
    }

    @Override
    public boolean removeUser(int userId) {
        Optional<User> user = findUser(userId);
        if (user.isPresent()) {
            if (!user.get().getBorrowedBookIds().isEmpty()) return false;
            users.remove(user.get());
            return true;
        }
        return false;
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public boolean issueBook(int bookId, int userId) {
        Optional<Book> bookOpt = findBook(bookId);
        Optional<User> userOpt = findUser(userId);
        if (!bookOpt.isPresent() || !userOpt.isPresent()) return false;

        Book book = bookOpt.get();
        User user = userOpt.get();

        if (book.isIssued()) return false;

        book.issueTo(user.getId());
        user.borrowBook(book.getId());
        return true;
    }

    @Override
    public boolean returnBook(int bookId, int userId) {
        Optional<Book> bookOpt = findBook(bookId);
        Optional<User> userOpt = findUser(userId);
        if (!bookOpt.isPresent() || !userOpt.isPresent()) return false;

        Book book = bookOpt.get();
        User user = userOpt.get();

        if (!book.isIssued() || book.getIssuedToUserId() != userId) return false;

        boolean removed = user.returnBook(bookId);
        if (!removed) return false;

        book.returned();
        return true;
    }

    private Optional<Book> findBook(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    private Optional<User> findUser(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }
}

