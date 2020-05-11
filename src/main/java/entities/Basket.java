package entities;

import java.util.Objects;

public class Basket {

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
        Basket basket = (Basket) o;
        return id == basket.id &&
                bookId == basket.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId);
    }
}
