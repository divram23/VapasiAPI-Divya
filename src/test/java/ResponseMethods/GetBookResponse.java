package ResponseMethods;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBookResponse {
   @JsonProperty("bookName")

    private String book;
    private String isbn;
    private String aisle;
    private String author;

    public String getBook_name() {
        return book;
    }

    public void setBook_name(String book_name) {
        this.book = book;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
