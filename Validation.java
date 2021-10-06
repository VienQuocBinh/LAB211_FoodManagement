
package MyService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Validation {

    final static String DATE_FORMAT = "dd-MM-yyyy";

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            // Tat mode tu cong ngay
            // VD: 29/2/2021 
            // setLenient(true) -> 1/3/2021
            // setLenient(false) -> exception
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isCharOnlyString(String s) {
        try {
            String pattern = "[a-zA-Z ]+";
            if (!s.matches(pattern) || s.isBlank()) {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean confirmMessage() {
        boolean flag = false;
        int confirm = -1;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Do you want to remove this food? (1: yes / 0: no): ");
                confirm = sc.nextInt();
                if (confirm < 0 || confirm > 1) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Enter again");
                flag = true;
            }
        } while (flag);
        return confirm == 1;
    }
}
