public abstract class Vehicle implements Rentable {
    private String regNumber;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isRented;

    public Vehicle(String regNumber, String brand, String model, double basePricePerDay) {
        if (basePricePerDay <= 0) {
            throw new IllegalArgumentException("Päevahind peab olema positiivne!");
        }
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isRented = false;
    }

    // Liidese meetodite rakendamine
    @Override
    public boolean isAvailable() {
        return !isRented;
    }

    @Override
    public void rentVehicle() {
        if (isRented) {
            throw new IllegalStateException("Sõiduk on juba välja renditud!");
        }
        this.isRented = true;
    }

    @Override
    public void returnVehicle() {
        if (!isRented) {
            throw new IllegalStateException("Sõiduk ei ole praegu renditud!");
        }
        this.isRented = false;
    }

    // Getterid ja Setterid (Kapseldamine)
    public String getRegNumber() { return regNumber; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getBasePricePerDay() { return basePricePerDay; }

    @Override
    public String toString() {
        return String.format("[%s] %s %s - Hind: %.2f€/päev | Oleks: %s",
                regNumber, brand, model, basePricePerDay, isRented ? "Renditud" : "Vaba");
    }
}