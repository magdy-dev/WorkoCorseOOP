package entities;

import java.util.Objects;

public class Transaction extends Entity{

    private int userId;
    private double price;
    private String date;
    private int bookId;

    public int getUserId() {
        return userId;
    }
    public double getPrice() {
        return price;
    }
    public String getDate() {
        return date;
    }
    public int getBookId() {
        return bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Transaction that = (Transaction) o;
        return userId == that.userId &&
                bookId == that.bookId &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId, price, date, bookId);
    }

    public boolean contains(Transaction transaction) {


        return false;
    }

    public void remove(Transaction transaction) {

    }
}
