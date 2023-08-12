import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// 11. Client application to call the remote method from the server
public class AgeCalculatorClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your birth date in the format (yyyy-mm-dd): ");
        String bDate = sc.nextLine();
        try {
            // 12. Locate the RMI registry running on the server (assuming it's on localhost)
            Registry registry = LocateRegistry.getRegistry("localhost");

            // 13. Look up the remote object by its registered name ("AgeCalculator")
            AgeCalculator calculator = (AgeCalculator) registry.lookup("AgeCalculator");

            // 14. Input the date of birth (DOB) from the user
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirth = sdf.parse(bDate);

            // 15. Call the remote method to calculate the age
            int age = calculator.calculateAge(dateOfBirth);
            System.out.println("Age calculated by server: " + age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
