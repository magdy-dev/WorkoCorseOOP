package entities;

import java.util.Objects;

public class Order {

    private int id;
    private int transactionId;
    private int bookId;

    public int getId() {
        return id;
    }
    public int getTransactionId() {
        return transactionId;
    }
    public int getBookId() {
        return bookId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                transactionId == order.transactionId &&
                bookId == order.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, bookId);
    }
}
