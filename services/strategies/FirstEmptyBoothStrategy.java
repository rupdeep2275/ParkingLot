package services.strategies;

import models.Booth;
import models.Gate;
import models.ParkingLot;
import models.enums.ParkingBoothStatus;
import models.enums.VehicleType;
import repositories.BoothRepository;
import repositories.ParkingLotRepository;

import java.util.List;
import java.util.Optional;

public class FirstEmptyBoothStrategy implements BoothAllocationStrategy{
    private ParkingLotRepository parkingLotRepository;
    private BoothRepository boothRepository;
    public FirstEmptyBoothStrategy(ParkingLotRepository parkingLotRepository, BoothRepository boothRepository){
        this.parkingLotRepository = parkingLotRepository;
        this.boothRepository = boothRepository;
    }
    @Override
    public Optional<Booth> assignBooth(VehicleType vehicleType, Gate gate) {
        ParkingLot parkingLot = parkingLotRepository.fetchByGateId(gate.getId());
        List<Booth> parkingBooths = boothRepository.fetchAllBoothsByParkingLot(parkingLot.getId());
        for(Booth booth: parkingBooths){
            if(booth.getBoothStatus().equals(ParkingBoothStatus.AVAILABLE) && booth.getSupportedVehicleType().equals(vehicleType)){
                return Optional.of(booth);
            }
        }
        return Optional.empty();
    }
}
