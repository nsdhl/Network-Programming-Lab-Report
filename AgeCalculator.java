import java.rmi.*;
import java.util.*;

// 1. Remote interface defining the method to calculate age
public interface AgeCalculator extends Remote {
    // 2. Remote method to calculate the age based on the date of birth
    int calculateAge(Date dateOfBirth) throws RemoteException;
}
