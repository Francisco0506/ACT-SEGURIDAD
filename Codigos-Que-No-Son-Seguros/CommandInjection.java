// codigo de comando de inyeccion

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CommandInjection {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la direccion ip   a verificar: ");
        String ip = scanner.nextLine();

        String cmd = "ping " + ip;
        Process proceso = Runtime.getRuntime().exec (cmd);

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(proceso.getInputStream()));

        String linea;
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }

        proceso.waitFor();
        scanner.close();
    }
}