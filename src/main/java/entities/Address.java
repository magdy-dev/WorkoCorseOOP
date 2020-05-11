package entities;

import java.util.Objects;

public class Address extends Entity {
    private String country;
    private String region;
    private String street;
    private int apartment;

    public String getCountry() {
        return country;
    }
    public String getRegion() {
        return region;
    }
    public String getStreet() {
        return street;
    }
    public int getApartment() {
        return apartment;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return apartment == address.apartment &&
                Objects.equals(country, address.country) &&
                Objects.equals(region, address.region) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, region, street, apartment);
    }

}
