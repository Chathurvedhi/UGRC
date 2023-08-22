/*
Class Variable Example

The class object (user data) is assigned in the createUser function and used for the last time in the editUserEmail function. 
The class object remains alive with respect to the garbage collector until the end of the program's execution, despite its last meaningful usage occurring earlier in the sequence.
 */


class UserData {
    private String username;
    private String email;

    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

public class UserDatabase {
    private static UserData classObject; // Class variable

    public static void main(String[] args) {
        createAndEditUser("user123", "user123@example.com");
    }

    public static void createAndEditUser(String username, String email) {
        System.out.println("Creating and editing user");
        UserData user = createUser(username, email);
        editUserEmail(user);
        System.out.println("User creation and editing completed");
    }

    public static UserData createUser(String username, String email) {
        System.out.println("Creating user data");
        classObject = new UserData(username, email); // Assigning the class variable
        System.out.println("User data created");
        return classObject;
    }

    public static void editUserEmail(UserData user) {
        System.out.println("Editing user's email");
        user.setEmail("edited@example.com");
        System.out.println("User email edited");
    }
}
