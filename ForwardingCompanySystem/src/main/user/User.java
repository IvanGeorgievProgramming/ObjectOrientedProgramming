package main.user;

public class User {

    // * Variables

    private int id;             // TODO: Unique for every instance, Can`t be changed
    private String name;        // TODO: Can`t exist two users with the same name
    private String password;
    private Role role;

    // * Constructors

    public User(int id, String name, String password, Role role) {
        this.id = id;
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
