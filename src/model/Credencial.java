package model;

public class Credencial {
    private int id;
    private String tipo;
    private String username;
    private String password;

    public Credencial(int id, String tipo, String username, String password) {
        this.id = id;
        this.tipo = tipo;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}