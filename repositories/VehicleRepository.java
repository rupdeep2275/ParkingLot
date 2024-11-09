package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    private HashMap<Long, Vehicle> vehicleTable = new HashMap<>();
    private Long autoIncrementId = 0L;

    public Vehicle save(Vehicle vehicle){
        if(vehicle.getId() == null){
            autoIncrementId++;
            vehicle.setId(autoIncrementId);
            vehicleTable.put(autoIncrementId, vehicle);
        }
        else{
            vehicleTable.put(vehicle.getId(), vehicle);
        }
        return vehicle;
    }
    public Optional<Vehicle> fetchVehicleByNumber(String vehicleNumber){
        for(Vehicle vehicle : vehicleTable.values()){
            if(vehicle.getVehicleNumber().equals(vehicleNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }
}
