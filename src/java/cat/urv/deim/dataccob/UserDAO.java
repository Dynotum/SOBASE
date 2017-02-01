package cat.urv.deim.dataccob;
import cat.urv.deim.sob.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


public class UserDAO {
    
    
    public User getUser(String alias) throws SQLException, ParseException {
        Connection con;
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM DEMODB.USERS where nickname = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alias);
            ResultSet resultSet=ps.executeQuery();
            User user=null;
            if (resultSet.next()) {
            user=new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
            }
        return user;
    }
    
    public String getLogin (String alias, String pass) throws SQLException{
        Connection con;
        PreparedStatement ps;
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/demodb", "user", "pwd");
            con.setSchema("DEMODB");
            String query = "SELECT * FROM demodb.USERS WHERE nickname=? AND password=?";
           // System.out.println(alias + " " + pass);
            ps = con.prepareStatement(query);
            ps.setString(1, alias);
            ps.setString(2, pass);
            
            ResultSet resultSet=ps.executeQuery();
            if (resultSet.next()) 
                return alias;
            else return "";
    }
}
