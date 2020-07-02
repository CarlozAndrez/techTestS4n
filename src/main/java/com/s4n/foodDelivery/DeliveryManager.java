package com.s4n.foodDelivery;

public class DeliveryManager {


  public DeliveryPoint retrieveLastPosition(DeliveryPoint deliveryPoint,
      String instructionToNextDelivery) {
    for (String route : instructionToNextDelivery.split("")) {
      if (route.equals("A")) {
        deliveryPoint.direction.forward(deliveryPoint);
      } else if (route.equals("I")) {
        deliveryPoint.direction.left(deliveryPoint);
      } else if (route.equals("D")) {
        deliveryPoint.direction.right(deliveryPoint);
      }
    }
    return deliveryPoint;
  }

}
