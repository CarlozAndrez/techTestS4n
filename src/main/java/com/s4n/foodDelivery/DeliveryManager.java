package com.s4n.foodDelivery;

public class DeliveryManager {


  public DeliveryPoint retrieveLastPosition(DeliveryPoint deliveryPoint,
      String instructionToNextDelivery) {
    for (String route : instructionToNextDelivery.split("")) {
      if (route.equals("A")) {
        deliveryPoint.direction.applyMovement(deliveryPoint);
      }
    }
    return deliveryPoint;
  }

}
