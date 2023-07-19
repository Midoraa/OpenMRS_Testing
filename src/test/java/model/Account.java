package model;

public class Account {
    private String username;
    private String password;
    private String location;

    public Account() {
    }

    public Account(String username, String password, String location) {
        this.username = username;
        this.password = password;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
