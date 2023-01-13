package main.user;

public class UserDetails {

    // * Variables

    private int id;             // TODO: Unique for every instance, Can`t be changed
    private String firstName;
    private String lastName;
    private String telephone;   // TODO: Only numbers
    private int userId;         // TODO: Unique for the user Id

    private static int idCounter = 0;

    // * Constructors

    public UserDetails(String firstName, String lastName, String telephone, int userId) {
        this.id = idCounter++;              // ? Maybe idCounter++ change the value of idCounter
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.userId = userId;
    }

    public UserDetails(UserDetails userDetails) {
        this.id = userDetails.id;
        this.firstName = userDetails.firstName;
        this.lastName = userDetails.lastName;
        this.telephone = userDetails.telephone;
        this.userId = userDetails.userId;
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

    public int getUserId() {
        return userId;
    }

    // * Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
