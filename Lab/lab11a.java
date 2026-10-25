
import java.sql.*;
import java.util.Scanner;

class lab11a {

    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:ucanaccess://ICE_PUST.accdb");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO Student ([Name], Email, Phone) VALUES (?, ?, ?)");

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, phone);

        ps.executeUpdate();
        System.out.println("Record Inserted Successfully!");

        con.close();
        sc.close();
    }
}
