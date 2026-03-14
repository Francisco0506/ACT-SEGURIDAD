import java.sql.Connection;
import java.sql.DriverManager;

public class HardcodedPassword {

    private static String dbUser = "admin";
    private static String dbPassword = "SuperSecreto123!";
    private static String apiKey = "sk-abc123def456ghi789jkl012";

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/produccion";

        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        System.out.println("Conectado con usuario: " + dbUser);
        System.out.println("API Key: " + apiKey);

        conn.close();
    }
}