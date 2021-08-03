package revature;

public class AccountCreation {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String password;


    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress(){
        return emailAddress;
    }

    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }
    public String getStreetAddress(){return streetAddress;}

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return city;
    }

    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }

    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
    public String getZipCode(){
        return zipCode;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}
