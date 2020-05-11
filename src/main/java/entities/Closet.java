package entities;

import java.util.Objects;

public class Closet extends Entity{

    private int shelfId;

    public int getShelfId() {
        return shelfId;
    }

    public void setShelfId(int shelfId) {
        this.shelfId = shelfId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Closet closet = (Closet) o;
        return shelfId == closet.shelfId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelfId);
    }

}
