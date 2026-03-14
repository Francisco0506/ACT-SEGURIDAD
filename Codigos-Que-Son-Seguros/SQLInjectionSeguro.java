import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SQLInjectionSeguro {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su password: ");
        String password = scanner.nextLine();

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/midb", "root", "root");

        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, usuario);
        pstmt.setString(2, password);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("Bienvenido " + rs.getString("username"));
        } else {
            System.out.println("Credenciales incorrectas");
        }

        rs.close();
        pstmt.close();
        conn.close();
        scanner.close();
    }
}