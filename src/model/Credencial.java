package model;

public class Credencial {
    private String username;
    private String password;

    public Credencial(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}