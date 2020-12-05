import java.sql.*;

public class LoginDAO {
    public int getUserType(UserCredentialsModel user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root","");

        String query = "select userType from users where userName=? and password=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, user.getUserName());
        pst.setString(2, user.getPassword());
        ResultSet rs = pst.executeQuery();
        rs.next();
        int userType = rs.getInt(1);

        return userType;

    }
}
