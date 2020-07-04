package com.s4n.foodDelivery.domain.service;

import static com.s4n.foodDelivery.application.constants.CommonConstants.GO_FORWARD_FLAG;
import static com.s4n.foodDelivery.application.constants.CommonConstants.MAX_UNITS_ALLOWED;
import static com.s4n.foodDelivery.application.constants.CommonConstants.TURN_LEFT_FLAG;
import static com.s4n.foodDelivery.application.constants.CommonConstants.TURN_RIGHT_FLAG;

import com.s4n.foodDelivery.adapters.FlatFileReportAdapter;
import com.s4n.foodDelivery.application.exceptions.DeliveryManagerException;
import com.s4n.foodDelivery.domain.CartesianPositions;
import com.s4n.foodDelivery.domain.DeliveryPoint;
import com.s4n.foodDelivery.domain.DroneRoute;
import com.s4n.foodDelivery.ports.drivers.IngestDroneRoute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryManager implements IngestDroneRoute {


  @Override
  public void ingestDroneDeliveryInformation(List<DroneRoute> droneRoutes) throws IOException {
    FlatFileReportAdapter flatFileReportAdapter = new FlatFileReportAdapter();
    for (DroneRoute droneRoute : droneRoutes) {
      List<DeliveryPoint> deliveryPointsByDrone = new ArrayList<>();
      DeliveryPoint deliveryPoint = new DeliveryPoint(
          getInitialDeliveryPoint(droneRoute.getDroneID()));
      for (String nextDeliveryInstruction : droneRoute.getDeliveryInstructions()) {
        deliveryPointsByDrone
            .add(new DeliveryPoint(goToNextDeliveryPoint(deliveryPoint, nextDeliveryInstruction)));
      }
      flatFileReportAdapter.exportReport(deliveryPointsByDrone);
    }
  }

  protected DeliveryPoint goToNextDeliveryPoint(DeliveryPoint deliveryPoint,
      String instructionToNextDelivery) {
    for (String route : instructionToNextDelivery.split("")) {
      if (route.equals(GO_FORWARD_FLAG)) {
        deliveryPoint.getDirection().forward(deliveryPoint);
        validateMaxCartesianUnitsAllowed(deliveryPoint);
      } else if (route.equals(TURN_LEFT_FLAG)) {
        deliveryPoint.getDirection().left(deliveryPoint);
      } else if (route.equals(TURN_RIGHT_FLAG)) {
        deliveryPoint.getDirection().right(deliveryPoint);
      }
    }
    return deliveryPoint;
  }

  private void validateMaxCartesianUnitsAllowed(DeliveryPoint deliveryPoint) {
    if (deliveryPoint.getX() > 10 || deliveryPoint.getX() < -10 || deliveryPoint.getY() > 10
        || deliveryPoint.getY() < -10) {
      throw new DeliveryManagerException(300L,
          String.format("You have exceeded the allowed units within the delivery map which is %d ",
              MAX_UNITS_ALLOWED));
    }
  }

  private DeliveryPoint getInitialDeliveryPoint(String droneID) {
    return new DeliveryPoint(0, 0, CartesianPositions.Y_POSITIVE, droneID);
  }
}
