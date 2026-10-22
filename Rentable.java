public interface Rentable {
    boolean isAvailable();
    void rentVehicle();
    void returnVehicle();
    double calculateRentalPrice(int days);
}