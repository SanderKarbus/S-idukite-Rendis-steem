import java.util.Scanner;

public class Main {
    private static RentalService service = new RentalService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData(); // Algandmete sisestamine

        boolean running = true;
        System.out.println("=== SÕIDUKITE RENDISÜSTEEM ===");

        while (running) {
            printMenu();
            System.out.print("Vali tegevus (1-6): ");
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> showAll();
                    case "2" -> showAvailable();
                    case "3" -> showSortedByPrice();
                    case "4" -> rentVehicleUI();
                    case "5" -> returnVehicleUI();
                    case "6" -> {
                        running = false;
                        System.out.println("Aitäh kasutamast! Head aega.");
                    }
                    default -> System.out.println("Vigane valik! Palun sisesta number 1-6.");
                }
            } catch (Exception e) {
                // Vigade ja erandite vigadeta käsitlemine
                System.out.println("VIGA: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void seedData() {
        service.addVehicle(new Car("123ABC", "BMW", "5. seeria", 45.0, "Luksus"));
        service.addVehicle(new Car("456DEF", "Toyota", "Corolla", 25.0, "Sedaan"));
        service.addVehicle(new Car("789GHI", "Volvo", "XC90", 40.0, "Maastur"));
        service.addVehicle(new Motorcycle("01MOTO", "Yamaha", "MT-07", 30.0, 689));
        service.addVehicle(new Motorcycle("02MOTO", "Honda", "CB500F", 20.0, 471));
    }

    private static void printMenu() {
        System.out.println("\n1. Kuva kõik sõidukid");
        System.out.println("2. Kuva vabad sõidukid (Filtreerimine)");
        System.out.println("3. Kuva sõidukid hinna järgi (Sorteerimine)");
        System.out.println("4. Rendi sõiduk");
        System.out.println("5. Tagasta sõiduk");
        System.out.println("6. Välju");
    }

    private static void showAll() {
        System.out.println("\n--- Kõik sõidukid ---");
        service.getAllVehicles().forEach(System.out::println);
    }

    private static void showAvailable() {
        System.out.println("\n--- Vabad sõidukid ---");
        service.filterAvailableVehicles().forEach(System.out::println);
    }

    private static void showSortedByPrice() {
        System.out.println("\n--- Sõidukid sorteeritud hinna järgi ---");
        service.sortByPrice().forEach(System.out::println);
    }

    private static void rentVehicleUI() {
        System.out.print("Sisesta renditava sõiduki reg. number: ");
        String reg = scanner.nextLine().trim();
        Vehicle v = service.findByRegNumber(reg);

        if (v == null) {
            System.out.println("Sellise reg. numbriga sõidukit ei leitud!");
            return;
        }

        System.out.print("Mitu päeva soovid rentida? ");
        int days = Integer.parseInt(scanner.nextLine().trim());
        
        if (days <= 0) {
            System.out.println("Päevade arv peab olema vähemalt 1!");
            return;
        }

        v.rentVehicle(); // Muudab oleku
        double totalPrice = v.calculateRentalPrice(days); // Polümorfne arvutus
        System.out.printf("Sõiduk %s edukalt renditud! Kokku tasuda: %.2f€\n", reg, totalPrice);
    }

    private static void returnVehicleUI() {
        System.out.print("Sisesta tagastatava sõiduki reg. number: ");
        String reg = scanner.nextLine().trim();
        Vehicle v = service.findByRegNumber(reg);

        if (v == null) {
            System.out.println("Sellise reg. numbriga sõidukit ei leitud!");
            return;
        }

        v.returnVehicle();
        System.out.println("Sõiduk " + reg + " on edukalt tagastatud!");
    }
}