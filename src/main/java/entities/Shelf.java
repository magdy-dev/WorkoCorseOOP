package entities;

import java.util.Objects;

public class Shelf {

    private int id;
    private int bookId;

    public int getId() {
        return id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelf shelf = (Shelf) o;
        return id == shelf.id &&
                bookId == shelf.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId);
    }
}
