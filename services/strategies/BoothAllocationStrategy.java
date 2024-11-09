package services.strategies;

import models.Booth;
import models.Gate;
import models.Vehicle;
import models.enums.VehicleType;

import java.util.Optional;

public interface BoothAllocationStrategy {
    Optional<Booth> assignBooth(VehicleType vehicleType, Gate gate);
}
