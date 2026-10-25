
import java.sql.*;
import java.util.Scanner;

public class lab12 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "i love it"
        );

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Edit");
            System.out.println("4. Show");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO Student VALUES (?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, email);
                ps.setString(4, phone);
                ps.executeUpdate();

                System.out.println("Record inserted successfully.");
            } else if (ch == 2) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();

                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM Student WHERE id=?");
                ps.setInt(1, id);
                int rows = ps.executeUpdate();

                System.out.println(rows > 0 ? "Record deleted." : "ID not found.");
            } else if (ch == 3) {
                System.out.print("Enter ID to edit: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("New Name: ");
                String name = sc.nextLine();

                System.out.print("New Email: ");
                String email = sc.nextLine();

                System.out.print("New Phone: ");
                String phone = sc.nextLine();

                PreparedStatement ps = con.prepareStatement(
                        "UPDATE Student SET name=?, email=?, phone=? WHERE id=?");
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setInt(4, id);
                int rows = ps.executeUpdate();

                System.out.println(rows > 0 ? "Record updated." : "ID not found.");
            } else if (ch == 4) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Student");

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("id") + " | "
                            + rs.getString("name") + " | "
                            + rs.getString("email") + " | "
                            + rs.getString("phone"));
                }
                rs.close();
                st.close();
            } else if (ch == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        con.close();
        sc.close();
    }
}
