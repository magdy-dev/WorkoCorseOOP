package entities;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private int authorId;
    private int numberOfPages;
    private int categoryId;
    private boolean status;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAuthorId() {
        return authorId;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public int getCategoryId() {
        return categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isReserved() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                authorId == book.authorId &&
                numberOfPages == book.numberOfPages &&
                categoryId == book.categoryId &&
                status == book.status &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authorId, numberOfPages, categoryId, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", numberOfPages=" + numberOfPages +
                ", categoryId=" + categoryId +
                '}';
    }
}
