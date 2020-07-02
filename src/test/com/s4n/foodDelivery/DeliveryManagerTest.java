package com.s4n.foodDelivery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DeliveryManagerTest {


  @Test
  public void verify_OneDeliveryPoint() {

    DeliveryManager deliveryManager = new DeliveryManager();
    DeliveryPoint deliveryPoint = deliveryManager
        .retrieveLastPosition(new DeliveryPoint(0, 0,CompassDirection.Y_PLUS), "AAAAIAA");

    assertEquals(4, deliveryPoint.getY());
    assertEquals(-2, deliveryPoint.getX());
  }

  @Test
  public void verify_TwoDeliveryPoint() {

    DeliveryManager deliveryManager = new DeliveryManager();
    DeliveryPoint deliveryPoint_1 = deliveryManager
        .retrieveLastPosition(new DeliveryPoint(0, 0,CompassDirection.Y_PLUS), "AAAAIAA");
    deliveryPoint_1.direction = CompassDirection.Y_PLUS;
    DeliveryPoint deliveryPoint_2 = deliveryManager
        .retrieveLastPosition(deliveryPoint_1, "DDDAIAD");

    assertEquals(-3, deliveryPoint_2.getX());
    assertEquals(3, deliveryPoint_2.getY());
  }

}