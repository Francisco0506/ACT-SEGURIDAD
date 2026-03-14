import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CommandInjectionSeguro {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la direccion IP a verificar: ");
        String ip = scanner.nextLine();

        String regex = "^([0-9]{1,3}\\.){3}[0-9]{1,3}$";
        if (!Pattern.matches(regex, ip)) {
            System.out.println("Error: IP no valida");
            scanner.close();
            return;
        }

        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "4", ip);
        Process proceso = pb.start();

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