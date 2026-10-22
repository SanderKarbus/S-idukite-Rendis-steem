public class Car extends Vehicle {
    private String carType; // nt "Sedaan", "Maastur", "Luksus"

    public Car(String regNumber, String brand, String model, double basePricePerDay, String carType) {
        super(regNumber, brand, model, basePricePerDay);
        this.carType = carType;
    }

    // Polümorfism: Autode puhul lisandub luksusautole lisatasu
    @Override
    public double calculateRentalPrice(int days) {
        double multiplier = 1.0;
        if ("Luksus".equalsIgnoreCase(carType)) {
            multiplier = 1.5;
        } else if ("Maastur".equalsIgnoreCase(carType)) {
            multiplier = 1.2;
        }
        return getBasePricePerDay() * days * multiplier;
    }

    public String getCarType() { return carType; }

    @Override
    public String toString() {
        return super.toString() + " (Auto tüüp: " + carType + ")";
    }
}