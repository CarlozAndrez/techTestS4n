package com.s4n.foodDelivery.ports.driven;

import com.s4n.foodDelivery.domain.DroneRoute;
import java.util.List;

public interface DeliveryReader {

  public List<DroneRoute> readDeliveryInformation(String pathName);
}


