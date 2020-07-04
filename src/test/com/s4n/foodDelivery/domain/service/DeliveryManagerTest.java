package com.s4n.foodDelivery.domain.service;

import static org.junit.Assert.assertEquals;

import com.s4n.foodDelivery.domain.CartesianPositions;
import com.s4n.foodDelivery.domain.DeliveryPoint;
import com.s4n.foodDelivery.domain.DroneRoute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

public class DeliveryManagerTest {


  @Test
  public void verify_OneDeliveryPoint() {

    DeliveryManager deliveryManager = new DeliveryManager();
    DeliveryPoint deliveryPoint = deliveryManager
        .goToNextDeliveryPoint(new DeliveryPoint(0, 0, CartesianPositions.Y_POSITIVE, "01"),
            "AAAAIAA");

    assertEquals(4, deliveryPoint.getY());
    assertEquals(-2, deliveryPoint.getX());
  }

  @Test
  public void verify_TwoDeliveryPoint() {

    DeliveryManager deliveryManager = new DeliveryManager();
    DeliveryPoint deliveryPoint_1 = deliveryManager
        .goToNextDeliveryPoint(new DeliveryPoint(0, 0, CartesianPositions.Y_POSITIVE, "01"),
            "AAAAIAA");
    DeliveryPoint deliveryPoint_2 = deliveryManager
        .goToNextDeliveryPoint(deliveryPoint_1, "DDDAIAD");
    assertEquals(-1, deliveryPoint_2.getX());
    assertEquals(3, deliveryPoint_2.getY());
  }

  @Test
  public void verify_ThreeDeliveryPoint() {

    DeliveryManager deliveryManager = new DeliveryManager();
    DeliveryPoint deliveryPoint_1 = deliveryManager
        .goToNextDeliveryPoint(new DeliveryPoint(0, 0, CartesianPositions.Y_POSITIVE, "01"),
            "AAAAIAA");
    DeliveryPoint deliveryPoint_2 = deliveryManager
        .goToNextDeliveryPoint(deliveryPoint_1, "DDDAIAD");
    DeliveryPoint deliveryPoint_3 = deliveryManager
        .goToNextDeliveryPoint(deliveryPoint_2, "AAIADAD");
    assertEquals(0, deliveryPoint_3.getX()); //Expected :-4    Actual   :-6
    assertEquals(0, deliveryPoint_3.getY());
  }


  @Test
  public void ingestDroneDeliveryInformation() throws IOException {
    DeliveryManager deliveryManager = new DeliveryManager();
    List<String> deliveryPoints = new LinkedList<>();
    deliveryPoints.add("AAAAIAA");
    deliveryPoints.add("DDDAIAD");
    deliveryPoints.add("AAIADAD");
    DroneRoute droneRoute = new DroneRoute();
    droneRoute.setDroneID("01");
    droneRoute.setDeliveryInstructions(deliveryPoints);
    List<DroneRoute> droneRoutes = new ArrayList<>();
    droneRoutes.add(droneRoute);
    deliveryManager.ingestDroneDeliveryInformation(droneRoutes);

  }

  @Test
  public void retrieveLastPosition() {
  }
}