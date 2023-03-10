package main.user;

public class User {

    // * Variables

    private final int id;
    private String name;
    private String password;
    private Role role;

    private static int idCounter = 0;

    // * Constructors

    public User(String name, String password, Role role) {
        this.id = idCounter++;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(User user) {
        this.id = user.id;
        this.name = user.name;
        this.password = user.password;
        this.role = user.role;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    // * Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
