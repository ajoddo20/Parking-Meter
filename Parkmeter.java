import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class _Assignment_1 {

    enum cityLocation {
        HIGH_TRAFFIC, MEDIUM_TRAFFIC, LOW_TRAFFIC
    }

    enum pricePerHour {
        $4, $2, $1
    }

    public static void main(String[] args) {

        int rate = 1;
        String carPlate;
        LocalDateTime now = LocalDateTime.now();
        Scanner keyboard = new Scanner(System.in);
        double initialPayment = 1;
        int dab = 1;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter hourFormatter = DateTimeFormatter.ofPattern("HH");
        int currentHour = Integer.parseInt(hourFormatter.format(now));
        DateTimeFormatter minuteFormatter = DateTimeFormatter.ofPattern("mm");
        int currentMinute = Integer.parseInt(minuteFormatter.format(now));

        System.out.print("Enter your car plate: ");
        carPlate = keyboard.nextLine();

        while (dab == 1) {

            System.out.println("Select amount to be charged to your credit card");
            System.out.println("1: -$1.00");
            System.out.println("2: +$1.00");
            System.out.println("3: Complete Transaction");
            System.out.print("\nSelect Parking Payment Option: ");
            int amountCharged = keyboard.nextInt();

            switch (amountCharged) {
                case 1:
                    initialPayment--;
                    if (initialPayment < 1) {
                        System.out.println("Payment below 0\n");
                        break;
                    }
                    if (rate == 4) {
                        currentMinute = currentMinute - 15;
                    }
                    if (rate == 2) {
                        currentMinute = currentMinute - 30;
                    }
                    if (rate == 1) {
                        currentMinute = currentMinute - 60;
                    }
                    if (currentMinute <= 0) {
                        currentMinute = currentMinute + 60;
                        currentHour = currentHour - 1;
                    }
                    if (currentHour < 1) {
                        currentHour = currentHour + 24;
                    }
                    System.out.println("Paid Until: " + currentHour + ":" + currentMinute);
                    System.out.println("Current Charge: $" + initialPayment + "0\n");
                    break;
                case 2:
                    initialPayment++;
                    if (rate == 4) {
                        currentMinute = currentMinute + 15;
                    }
                    if (rate == 2) {
                        currentMinute = currentMinute + 30;
                    }
                    if (rate == 1) {
                        currentMinute = currentMinute + 60;
                    }
                    if (currentMinute >= 60) {
                        currentMinute = currentMinute - 60;
                        currentHour = currentHour + 1;
                    }
                    if (currentHour > 24) {
                        currentHour = currentHour - 24;
                    }
                    System.out.println("Paid Until: " + currentHour + ":" + currentMinute);
                    System.out.println("Current Charge: $" + initialPayment + "0\n");
                    break;
                case 3:
                    System.out.println("\nPittsburh Parking Authority");
                    System.out.println("Plate: " + carPlate);
                    System.out.println("Valid: " + (dtf2.format(now)));
                    System.out.println("Until: " + currentHour + ":" + currentMinute);
                    dab++;
                default:
                    System.out.println("\nInvalid Option. Please try again");
                    System.out.println("Paid Until: " + currentHour + ":" + currentMinute);
                    System.out.println("Current Charge: $" + initialPayment + "0\n");
            }
        }
    }
}
