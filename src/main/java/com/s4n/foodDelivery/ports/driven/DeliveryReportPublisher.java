package com.s4n.foodDelivery.ports.driven;

import com.s4n.foodDelivery.domain.DeliveryPoint;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface DeliveryReportPublisher {

  public void exportReport(List<DeliveryPoint> deliveryPointsByDrone) throws IOException;
}


