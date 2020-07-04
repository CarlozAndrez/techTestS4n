package com.s4n.foodDelivery.ports.drivers;

import com.s4n.foodDelivery.domain.DroneRoute;
import java.io.IOException;
import java.util.List;

public interface IngestDroneRoute {

  public void ingestDroneDeliveryInformation(List<DroneRoute> droneRoutes) throws IOException;
}


