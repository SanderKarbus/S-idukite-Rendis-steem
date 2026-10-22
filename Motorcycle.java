public class Motorcycle extends Vehicle {
    private int engineCc; // Mootori maht kuupsentimeetrites

    public Motorcycle(String regNumber, String brand, String model, double basePricePerDay, int engineCc) {
        super(regNumber, brand, model, basePricePerDay);
        this.engineCc = engineCc;
    }

    // Polümorfism: Suure mootoriga rattad on kallimad
    @Override
    public double calculateRentalPrice(int days) {
        double multiplier = (engineCc > 600) ? 1.3 : 1.0;
        return getBasePricePerDay() * days * multiplier;
    }

    public int getEngineCc() { return engineCc; }

    @Override
    public String toString() {
        return super.toString() + " (Mootor: " + engineCc + "cc)";
    }
}