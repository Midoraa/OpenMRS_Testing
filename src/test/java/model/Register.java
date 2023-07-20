package model;

public class Register {
    private String firstName;
    private String midleName;
    private String lastName;
    private String gender;
    private String days;
    private String month;
    private String years;
    private String address;
    private String address1;
    private String cityOrVillage;
    private String stateOrProvince;
    private String country;
    private String postalCode;
    private String numberPhone;
    private String relationship;
    private String personName;

    public Register(String firstName, String midleName, String lastName, String gender, String days, String month, String years, String address, String address1, String cityOrVillage, String stateOrProvince, String country, String postalCode, String numberPhone, String relationship, String personName) {
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.gender = gender;
        this.days = days;
        this.month = month;
        this.years = years;
        this.address = address;
        this.address1 = address1;
        this.cityOrVillage = cityOrVillage;
        this.stateOrProvince = stateOrProvince;
        this.country = country;
        this.postalCode = postalCode;
        this.numberPhone = numberPhone;
        this.relationship = relationship;
        this.personName = personName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCityOrVillage() {
        return cityOrVillage;
    }

    public void setCityOrVillage(String cityOrVillage) {
        this.cityOrVillage = cityOrVillage;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
