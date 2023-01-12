package main.user;

public class UserDetails {

    // * Variables

    private int id;             // TODO: Unique for every instance, Can`t be changed
    private String firstName;
    private String lastName;
    private String telephone;   // TODO: Only numbers
    private int userId;         // TODO: Unique for the user Id

    // * Constructors

    public UserDetails(int id, String firstName, String lastName, String telephone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public UserDetails(UserDetails userDetails) {
        this.id = userDetails.id;
        this.firstName = userDetails.firstName;
        this.lastName = userDetails.lastName;
        this.telephone = userDetails.telephone;
    }

    // * Getters

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    // * Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
