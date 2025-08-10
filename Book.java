public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private boolean issued;
    private int issuedToUserId; 

    public Book(int id, String title, String author, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.issued = false;
        this.issuedToUserId = -1;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isIssued() { return issued; }
    public int getIssuedToUserId() { return issuedToUserId; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public void issueTo(int userId) {
        this.issued = true;
        this.issuedToUserId = userId;
    }

    public void returned() {
        this.issued = false;
        this.issuedToUserId = -1;
    }

    @Override
    public String toString() {
        return String.format("Book{id=%d, title='%s', author='%s', isbn='%s', issued=%s, issuedTo=%d}",
                id, title, author, isbn, issued, issuedToUserId);
    }
}
