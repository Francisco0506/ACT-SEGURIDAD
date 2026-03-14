import java.sql.Connection;
import java.sql.DriverManager;

public class HardcodedPasswordSeguro {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/produccion";

        String dbUser = System.getenv("DB_USER");
        String dbPassword = System.getenv("DB_PASSWORD");
        String apiKey = System.getenv("API_KEY");

        if (dbUser == null || dbPassword == null) {
            System.out.println("Error: Variables de entorno no configuradas");
            return;
        }

        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        System.out.println("Conectado exitosamente");

        conn.close();
    }
}
//prueba
