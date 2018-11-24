using System;

namespace VacationCostsStayTransport
{
    class VacationCostsStayTransport
    {
        static void Main(string[] args)
        {

            try
            {
                //input and checking for invalid input for number of tourist
                Console.Write("Enter number of tourists (1 - 200): ");
                int tourists = int.Parse(Console.ReadLine());
                while (tourists < 1 || tourists > 200)
                {
                    Console.Write("Invalid input for number of tourists. " +
                            "Tourists must be between 1 and 200: ");
                    tourists = int.Parse(Console.ReadLine());
                }

                //input and checking for invalid input for number of nights
                Console.Write("Enter number of nights (1 - 31): ");
                int nights = int.Parse(Console.ReadLine());
                while (nights < 1 || nights > 31)
                {
                    Console.Write("Invalid input for number of nights. " +
                            "Nights must be between 1 and 31: ");
                    nights = int.Parse(Console.ReadLine());
                }

                //input and checking for invalid input for group of tourists
                Console.Write("Enter type of group - \"Students\", \"Business\" or \"Regular\": ");
                string groupType = Console.ReadLine().ToLower();
                while (!("students".Equals(groupType)) &&
                        !("business".Equals(groupType)) &&
                        !("regular".Equals(groupType)))
                {
                    Console.Write("Invalid input for type of group. " +
                            "The 3 options are \"Students\", \"Business\" or \"Regular\": ");
                    groupType = Console.ReadLine().ToLower();
                }

                //input and checking for invalid input for transport
                Console.Write("Enter type of transport - \"Train\", \"Bus\" or \"Car\": ");
                string transportVehicle = Console.ReadLine().ToLower();
                while (!("train".Equals(transportVehicle)) &&
                        !("bus".Equals(transportVehicle)) &&
                        !("car".Equals(transportVehicle)))
                {
                    Console.Write("Invalid input for type of transport. " +
                            "The 3 options are \"Train\", \"Bus\" or \"Car\": ");
                    transportVehicle = Console.ReadLine().ToLower();
                }

                //input and checking for invalid input for season
                Console.Write("Enter season - \"Spring\", \"Summer\" or \"Winter\": ");
                string season = Console.ReadLine().ToLower();
                while (!("spring".Equals(season)) &&
                        !("summer".Equals(season)) &&
                        !("winter".Equals(season)))
                {
                    Console.Write("Invalid input for season. " +
                            "The 3 options are \"Spring\", \"Summer\" or \"Winter\": ");
                    season = Console.ReadLine().ToLower();
                }

                //CALCULATIONS FOR STAYING AT THE HOTEL

                //price per a night a single tourist must pay
                double pricePerANight = 0;

                switch (season)
                {
                    case "winter":
                        switch (groupType)
                        {
                            case "students": pricePerANight = 8.45; break;
                            case "business": pricePerANight = 10.90; break;
                            case "regular": pricePerANight = 15; break;
                        }
                        break;

                    case "spring":
                        switch (groupType)
                        {
                            case "students": pricePerANight = 9.80; break;
                            case "business": pricePerANight = 15.60; break;
                            case "regular": pricePerANight = 20; break;
                        }
                        break;

                    case "summer":
                        switch (groupType)
                        {
                            case "students": pricePerANight = 10.46; break;
                            case "business": pricePerANight = 16; break;
                            case "regular": pricePerANight = 22.50; break;
                        }
                        break;
                }

                //total price per a night the whole group must pay without discounts
                double groupPricePerANight = pricePerANight * tourists;

                //discounts
                if ("students".Equals(groupType) && tourists >= 30)
                {
                    groupPricePerANight -= 0.15 * groupPricePerANight;
                }

                if ("business".Equals(groupType) && tourists >= 100)
                {
                    groupPricePerANight -= (10 * pricePerANight);
                }

                if ("regular".Equals(groupType) && tourists >= 10 && tourists <= 20)
                {
                    groupPricePerANight -= 0.05 * groupPricePerANight;
                }

                //printing costs for the hotel
                double groupPriceForAllNights = groupPricePerANight * nights;
                //the price one tourist must pay
                double individualPriceForAllNights = groupPriceForAllNights / tourists;

                Console.WriteLine($"Price per a night the group must pay: {groupPricePerANight:F2} lv.");
                Console.WriteLine($"Total price for all nights the group must pay: {groupPriceForAllNights:F2} lv.");
                Console.WriteLine($"Total price for all nights a single tourist must pay: {individualPriceForAllNights:F2} lv.");

                //CALCULATIONS FOR TRANSPORT

                //price per a one-way ticket a single tourist must pay
                int priceForOneWayTicket = 0;
                switch (transportVehicle)
                {
                    case "train":
                        switch (groupType)
                        {
                            case "students": priceForOneWayTicket = 12; break;
                            case "business": priceForOneWayTicket = 20; break;
                            case "regular": priceForOneWayTicket = 17; break;
                        }
                        break;

                    case "bus":
                        switch (groupType)
                        {
                            case "students": priceForOneWayTicket = 15; break;
                            case "business": priceForOneWayTicket = 24; break;
                            case "regular": priceForOneWayTicket = 19; break;
                        }
                        break;

                    case "car":
                        switch (groupType)
                        {
                            case "students": priceForOneWayTicket = 16; break;
                            case "business": priceForOneWayTicket = 25; break;
                            case "regular": priceForOneWayTicket = 20; break;
                        }
                        break;
                }

                //total price for a one-way ticket the whole group must pay without discounts
                double groupPriceForOneWayTicket = priceForOneWayTicket * tourists;

                //discounts
                if ("students".Equals(groupType) && tourists >= 20 &&
                        ("bus".Equals(transportVehicle) || "train".Equals(transportVehicle)))
                {
                    groupPriceForOneWayTicket -= 0.10 * groupPriceForOneWayTicket;
                }

                if ("business".Equals(groupType) && tourists >= 63)
                {
                    groupPriceForOneWayTicket -= (15 * priceForOneWayTicket);
                }

                if ("regular".Equals(groupType) && tourists >= 15 && tourists <= 30)
                {
                    groupPriceForOneWayTicket -= 0.07 * groupPriceForOneWayTicket;
                }

                double groupPriceForTwoWayTicket = 2 * groupPriceForOneWayTicket;
                //the price a single tourist must pay
                double individualPriceForTwoWayTicket = groupPriceForTwoWayTicket / tourists;

                //printing transport costs
                Console.WriteLine($"Transport costs for the group: {groupPriceForTwoWayTicket:F2} lv.");
                Console.WriteLine($"Transport costs for a single tourist: {individualPriceForTwoWayTicket:F2} lv");

                //printing total costs
                double totalGroupCosts = groupPriceForAllNights + groupPriceForTwoWayTicket;
                double totalIndividualCosts = totalGroupCosts / tourists;
                Console.WriteLine($"Total costs for hotel and transport for the group: {totalGroupCosts:F2} lv.");
                Console.WriteLine($"Total costs for hotel and transport for a single tourist: {totalIndividualCosts:F2} lv.");

            }
            catch
            {
                Console.WriteLine("Sorry, invalid input! Start from the beginning!");
            }

        }
    }
}