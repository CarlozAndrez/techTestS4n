package com.s4n.foodDelivery.domain;

import java.util.List;

public class DroneRoute {

  private String droneID;
  private List<String> deliveryInstructions;

  public String getDroneID() {
    return droneID;
  }

  public void setDroneID(String droneID) {
    this.droneID = droneID;
  }

  public List<String> getDeliveryInstructions() {
    return deliveryInstructions;
  }

  public void setDeliveryInstructions(List<String> deliveryInstructions) {
    this.deliveryInstructions = deliveryInstructions;
  }
}
