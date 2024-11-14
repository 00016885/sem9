package org.example;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookId implements Serializable {
    private String isbn;
    private String edition;

    public BookId(){

    }

    public BookId(String isbn, String edition) {
        this.isbn = isbn;
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BookId bookId = (BookId) obj;
        return Objects.equals(isbn, bookId.isbn)&&
                Objects.equals(edition, bookId.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, edition);
    }
}
