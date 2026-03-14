// Codigo de inyeccion de sql con 3 vulbnerabilidades 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInjection{
    public static void main (String[]args ) throws Exception{
        Scanner scanner = new Scanner (System.in);

        System.out.print("Ingrese su usuario");
        String username = scanner.nextLine();

        System.out.print("Ingrese su contraseña");
        String password = scanner.nextLine();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MIBD", "root", "password");
        Statement statement = connection.createStatement();

        String query = "Select * From Usuarios WHERE username = '" + username + "' and password = '" + password + "'";
        ResultSet rs = statement.executeQuery(query);

        if (rs.next()){
            System.out.println("Bienvenido " + rs.getString("username"));
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }

rs.close();
statement.close();
connection.close();
scanner.close();
    }
}
