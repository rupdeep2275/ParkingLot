package services;

import models.Vehicle;
import models.enums.VehicleType;
import repositories.VehicleRepository;

import java.util.Optional;

public class VehicleService {
    private VehicleRepository vehicleRepository;
    public VehicleService(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicle(String vehicleNumber, VehicleType vehicleType){
        Optional<Vehicle> vehicleWrapper = vehicleRepository.fetchVehicleByNumber(vehicleNumber);
        if(vehicleWrapper.isEmpty()){
            //register new vehicle
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            Vehicle savedVehicle = vehicleRepository.save(vehicle);
            return savedVehicle;
        }
        else{
            return vehicleWrapper.get();
        }
    }
}
