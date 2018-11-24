import java.util.Scanner;

public class VacationCostsStayTransport {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            //input and checking for invalid input for number of tourist
            System.out.print("Enter number of tourists (1 - 200): ");
            int tourists = Integer.parseInt(scanner.nextLine());
            while (tourists < 1 || tourists > 200) {
                System.out.print("Invalid input for number of tourists. " +
                        "Tourists must be between 1 and 200: ");
                tourists = Integer.parseInt(scanner.nextLine());
            }

            //input and checking for invalid input for number of nights
            System.out.print("Enter number of nights (1 - 31): ");
            int nights = Integer.parseInt(scanner.nextLine());
            while (nights < 1 || nights > 31) {
                System.out.print("Invalid input for number of nights. " +
                        "Nights must be between 1 and 31: ");
                nights = Integer.parseInt(scanner.nextLine());
            }

            //input and checking for invalid input for group of tourists
            System.out.print("Enter type of group - \"Students\", \"Business\" or \"Regular\": ");
            String groupType = (scanner.nextLine()).toLowerCase();
            while (!("students".equals(groupType)) &&
                    !("business".equals(groupType)) &&
                    !("regular".equals(groupType))) {
                System.out.print("Invalid input for type of group. " +
                        "The 3 options are \"Students\", \"Business\" or \"Regular\": ");
                groupType = (scanner.nextLine()).toLowerCase();
            }

            //input and checking for invalid input for transport
            System.out.print("Enter type of transport - \"Train\", \"Bus\" or \"Car\": ");
            String transportVehicle = (scanner.nextLine()).toLowerCase();
            while (!("train".equals(transportVehicle)) &&
                    !("bus".equals(transportVehicle)) &&
                    !("car".equals(transportVehicle))) {
                System.out.print("Invalid input for type of transport. " +
                        "The 3 options are \"Train\", \"Bus\" or \"Car\": ");
                transportVehicle = (scanner.nextLine()).toLowerCase();
            }

            //input and checking for invalid input for season
            System.out.print("Enter season - \"Spring\", \"Summer\" or \"Winter\": ");
            String season = (scanner.nextLine()).toLowerCase();
            while (!("spring".equals(season)) &&
                    !("summer".equals(season)) &&
                    !("winter".equals(season))) {
                System.out.print("Invalid input for season. " +
                        "The 3 options are \"Spring\", \"Summer\" or \"Winter\": ");
                season = (scanner.nextLine()).toLowerCase();
            }

            //CALCULATIONS FOR STAYING AT THE HOTEL

            //price per a night a single tourist must pay
            double pricePerANight = 0;
            if ("winter".equals(season)) {
                if ("students".equals(groupType)) {
                    pricePerANight = 8.45;
                } else if ("business".equals(groupType)) {
                    pricePerANight = 10.90;
                } else if ("regular".equals(groupType)) {
                    pricePerANight = 15;
                }
            } else if ("spring".equals(season)) {
                if ("students".equals(groupType)) {
                    pricePerANight = 9.80;
                } else if ("business".equals(groupType)) {
                    pricePerANight = 15.60;
                } else if ("regular".equals(groupType)) {
                    pricePerANight = 20;
                }
            } else if ("summer".equals(season)) {
                if ("students".equals(groupType)) {
                    pricePerANight = 10.46;
                } else if ("business".equals(groupType)) {
                    pricePerANight = 16;
                } else if ("regular".equals(groupType)) {
                    pricePerANight = 22.5;
                }
            }

            //total price per a night the whole group must pay without discounts
            double groupPricePerANight = pricePerANight * tourists;

            //discounts
            if ("students".equals(groupType) && tourists >= 30) {
                groupPricePerANight -= 0.15 * groupPricePerANight;
            }

            if ("business".equals(groupType) && tourists >= 100) {
                groupPricePerANight -= (10 * pricePerANight);
            }

            if ("regular".equals(groupType) && tourists >= 10 && tourists <= 20) {
                groupPricePerANight -= 0.05 * groupPricePerANight;
            }

            //printing costs for the hotel
            double groupPriceForAllNights = groupPricePerANight * nights;
            //the price one tourist must pay
            double individualPriceForAllNights = groupPriceForAllNights / tourists;

            System.out.printf("Price per a night the group must pay: %.2f lv.\n", groupPricePerANight);
            System.out.printf("Total price for all nights the group must pay: %.2f lv.\n",
                    (groupPriceForAllNights));
            System.out.printf("Total price for all nights a single tourist must pay: %.2f lv.\n",
                    individualPriceForAllNights);

            //CALCULATIONS FOR TRANSPORT

            //price per a one-way ticket a single tourist must pay
            double priceForOneWayTicket = 0;
            if ("train".equals(transportVehicle)) {
                if ("students".equals(groupType)) {
                    priceForOneWayTicket = 12;
                } else if ("business".equals(groupType)) {
                    priceForOneWayTicket = 20;
                } else if ("regular".equals(groupType)) {
                    priceForOneWayTicket = 17;
                }
            } else if ("bus".equals(transportVehicle)) {
                if ("students".equals(groupType)) {
                    priceForOneWayTicket = 15;
                } else if ("business".equals(groupType)) {
                    priceForOneWayTicket = 24;
                } else if ("regular".equals(groupType)) {
                    priceForOneWayTicket = 19;
                }
            } else if ("car".equals(transportVehicle)) {
                if ("students".equals(groupType)) {
                    priceForOneWayTicket = 16;
                } else if ("business".equals(groupType)) {
                    priceForOneWayTicket = 25;
                } else if ("regular".equals(groupType)) {
                    priceForOneWayTicket = 20;
                }
            }

            //total price for a one-way ticket the whole group must pay without discounts
            double groupPriceForOneWayTicket = priceForOneWayTicket * tourists;

            //discounts
            if ("students".equals(groupType) && tourists >= 20 &&
                    ("bus".equals(transportVehicle) || "train".equals(transportVehicle))) {
                groupPriceForOneWayTicket -= 0.10 * groupPriceForOneWayTicket;
            }

            if ("business".equals(groupType) && tourists >= 63) {
                groupPriceForOneWayTicket -= (15 * priceForOneWayTicket);
            }

            if ("regular".equals(groupType) && tourists >= 15 && tourists <= 30) {
                groupPriceForOneWayTicket -= 0.07 * groupPriceForOneWayTicket;
            }

            double groupPriceForTwoWayTicket = 2 * groupPriceForOneWayTicket;
            //the price a single tourist must pay
            double individualPriceForTwoWayTicket = groupPriceForTwoWayTicket / tourists;

            //printing transport costs
            System.out.printf("Transport costs for the group: %.2f lv.\n", groupPriceForTwoWayTicket);
            System.out.printf("Transport costs for a single tourist: %.2f lv.\n", individualPriceForTwoWayTicket);

            //printing total costs
            double totalGroupCosts = groupPriceForAllNights + groupPriceForTwoWayTicket;
            double totalIndividualCosts = totalGroupCosts / tourists;
            System.out.printf("Total costs for hotel and transport for the group: %.2f lv.\n",
                    totalGroupCosts);
            System.out.printf("Total costs for hotel and transport for a single tourist: %.2f lv.\n",
                    totalIndividualCosts);

        } catch (Exception ex) {
            System.out.println("Sorry, invalid input! Start from the beginning!");
        }
    }
}