package com.s4n.foodDelivery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeliveryManagerTest {


  @Test
  public void verify_OneDelivery_Drone_Move_Forward() {

    DeliveryManager deliveryManager = new DeliveryManager();
    DeliveryPoint deliveryPoint = deliveryManager
        .retrieveLastPosition(new DeliveryPoint(0, 0,CompassDirection.Y_PLUS), "AAAAIAA");

    assertEquals(6, deliveryPoint.getY());
  }


}