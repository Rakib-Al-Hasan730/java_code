
import java.sql.*;

class lab11b {

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:ucanaccess://ICE_PUST.accdb");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
                "SELECT * FROM Student");

        while (rs.next()) {
            System.out.println("Name: " + rs.getString("Name"));
            System.out.println("Email: " + rs.getString("Email"));
            System.out.println("Phone: " + rs.getString("Phone"));
            System.out.println();
        }

        con.close();
    }
}
