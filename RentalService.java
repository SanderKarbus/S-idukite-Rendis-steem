import java.util.*;
import java.util.stream.Collectors;

public class RentalService {
    // 1. Kollektsioon: Nimekiri sorteerimiseks ja filtreerimiseks
    private List<Vehicle> vehicleList = new ArrayList<>();
    
    // 2. Kollektsioon: Kiireks otsinguks registreerimisnumbri järgi
    private Map<String, Vehicle> vehicleMap = new HashMap<>();

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
        vehicleMap.put(vehicle.getRegNumber().toUpperCase(), vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(vehicleList);
    }

    // Otsing reg. numbri järgi (HashMap eelis: O(1) kiirus)
    public Vehicle findByRegNumber(String regNumber) {
        return vehicleMap.get(regNumber.toUpperCase());
    }

    // Filtreerimine: ainult vabad sõidukid
    public List<Vehicle> filterAvailableVehicles() {
        return vehicleList.stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toList());
    }

    // Sorteerimine: hinna järgi kasvavalt
    public List<Vehicle> sortByPrice() {
        List<Vehicle> sorted = new ArrayList<>(vehicleList);
        sorted.sort(Comparator.comparingDouble(Vehicle::getBasePricePerDay));
        return sorted;
    }
}