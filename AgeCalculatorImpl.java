import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

// 3. Implementation of the AgeCalculator remote interface
public class AgeCalculatorImpl extends UnicastRemoteObject implements AgeCalculator {

    public AgeCalculatorImpl() throws RemoteException {
        super(); // 4. Call the UnicastRemoteObject constructor
    }

    // 5. Remote method implementation to calculate the age
    @Override
    public int calculateAge(Date dateOfBirth) throws RemoteException {
        // 6. Calculate the age based on the date of birth
        Calendar dob = new GregorianCalendar();
        dob.setTime(dateOfBirth);
        Calendar now = new GregorianCalendar();
        int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }
}