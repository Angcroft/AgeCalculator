import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("When were you born? type in the (dd/MM/yyyy) format:");
        String birthDateString = scan.nextLine();

        try {
            LocalDate birthDate = LocalDate.parse(birthDateString, format);
            LocalDate currentDate = LocalDate.now();

            if (birthDate.isAfter(currentDate)) {
                System.out.println("The birth date can't be after the present!");
            } else {
                Period age = Period.between(birthDate, currentDate);
                System.out.println("Your age is: " + age.getYears() + " years, " + age.getMonths() + " months, and " + age.getDays() + " days old.");
            }
        } catch (Exception e) {
            System.out.println("Date format not valid! Please use the dd/MM/yyyy format.");
        }

        scan.close();
    }
}