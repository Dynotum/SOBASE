package cat.urv.deim.sob;

public class User {

    private String name;
    private String lastName;
    private String email;
    private String nickname;
    private String password;

    public User(String nickname, String password, String name, String lastName, String email ) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public User() {
    }


    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    

    public void setFirstName(String firstName) {
        this.name = firstName;
    }

    public String getLastName() {
        return fixNull(this.lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return fixNull(this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String fixNull(String in) {
        return (in == null) ? "" : in;
    }
/*
    public String getMessage() {

        return "\nFirst Name: " + getFirstName() + "\n"
                + "Last Name:  " + getLastName() + "\n"
                + "Email:      " + getEmail() + "\n"
                + "Phone:      " + getNickname() + "\n";
    }*/
    
        public String getSignUpSucceed() {

        return "<h2>SIGN UP SUCCEED</h2>"
                + "<b>NAME: " + getName() + "</b><br>"
                + "<b>LAST NAME:  " + getLastName() + "</b><br>"
                + "<b>NICKNAME:      " + getNickname()+"</b><br>"
                + "<b>PASSWORD:      " + getPassword() + "</b><br>";
    }
    public String getInfoaccount() {

        return "<table border=\"2px\" color=\"black\" style=\"margin: 0 auto;>"
             + "<tr>"
             +     "<td colspan= \"2\"><h2 ALIGN=center>USER INFORMATION</h2></td><br>"
             +   "</tr>"
                
             +  "<tr>"
             +    "<td>NAME:</td>"
             +    "<td>" + getName() + "</td>"
             +  "</tr>"
                
             +  "<tr>"
             +    "<td>LAST NAME:</td>"
             +    "<td>" + getLastName() + "</td>"
             +  "</tr>"

             +  "<tr>"
             +    "<td>NICKNAME:</td>"
             +    "<td>" + getNickname() + "</td>"
             +  "</tr>"

             +  "<tr>"
             +    "<td>EMAIL:</td>"
             +    "<td>" + getEmail() + "</td>"
             +  "</tr>"

             +  "<tr>"
             +    "<td>PASSWORD:</td>"
             +    "<td>" + getPassword() + "</td>"
             +  "</tr>"
                
             +  "</table>";
    }
    
}
