package model;

import java.util.regex.Pattern;

public class Customer {
    private String FirstName;
    private String LastName;
    private String email;
    public Customer(String FirstName,String LastName,String email){
        super();
        this.setFirstName(FirstName);
        this.setLastName(LastName);
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);

        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("error,invalid email");

        }
        this.setEmail(email);

    }
    @Override
    public String toString()
    {
        String text="Name:"+ getFirstName().toString()+" "+ getLastName().toString()+" "+"email:"+" "+ getEmail().toString();
        return text;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if ((this.FirstName.equalsIgnoreCase(((Customer) obj).FirstName) &&
                (this.LastName.equalsIgnoreCase(((Customer) obj).LastName)) &&
                (this.email.equalsIgnoreCase(((Customer) obj).email)))) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result+getEmail().hashCode();
        return result;
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
