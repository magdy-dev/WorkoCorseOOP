package entities;

import java.util.Objects;

public class Library extends Entity{

    private int closetId;

    public int getClosetId() {
        return closetId;
    }
    public void setClosetId(int closetId) {
        this.closetId = closetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Library library = (Library) o;
        return closetId == library.closetId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), closetId);
    }





}
