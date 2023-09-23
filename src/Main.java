import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        QueryCEP queryCEP = new QueryCEP();

        System.out.println("Put a CEP number for a query: ");
        String cep = scanner.nextLine();

        try {
            Address newAddress = queryCEP.findAddress(cep);
            System.out.println(newAddress);

            FileGenerator generator = new FileGenerator();
            generator.savedJson(newAddress);

        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finishing application");
        }
    }
}
