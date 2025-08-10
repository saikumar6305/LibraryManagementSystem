import java.util.ArrayList;
import java.util.List;

public class User extends Person {
    public enum Role { STUDENT, TEACHER, STAFF }
    private Role role;
    private List<Integer> borrowedBookIds;

    public User(int id, String name, String email, Role role) {
        super(id, name, email);
        this.role = role;
        this.borrowedBookIds = new ArrayList<>();
    }

    public Role getRoleEnum() { return role; }
    public String getRole() { return role.name(); }

    public List<Integer> getBorrowedBookIds() { return borrowedBookIds; }

    public void borrowBook(int bookId) {
        borrowedBookIds.add(bookId);
    }

    public boolean returnBook(int bookId) {
        return borrowedBookIds.remove(Integer.valueOf(bookId));
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', email='%s', role=%s, borrowed=%s}",
                id, name, email, role, borrowedBookIds);
    }
}
