package com.s4n.foodDelivery.adapters;

import static org.junit.Assert.assertEquals;

import com.s4n.foodDelivery.domain.DroneRoute;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ReadFromFlatFileAdapterTest {

  @Test
  public void readDeliveryInformation() {

    ReadFromFlatFileAdapter readFromFlatFileAdapter = new ReadFromFlatFileAdapter();
    List<DroneRoute> droneRoutes = readFromFlatFileAdapter
        .readDeliveryInformation("src/test/resources/");


    assertEquals(3, droneRoutes.size());
    assertEquals(Arrays.asList("DDAAIAA", "IAAAIAD", "AAIDDAA"), droneRoutes.get(0).getDeliveryInstructions());
    assertEquals(Arrays.asList("AAAAIAA", "DDDAIAD", "AAIADAD"), droneRoutes.get(1).getDeliveryInstructions());
    assertEquals(Arrays.asList("AAAADAA", "DIIAIAA", "AIIAADA"), droneRoutes.get(2).getDeliveryInstructions());
  }

  @Test
  public void getDroneID() {
  }

  @Test
  public void verifyFileNamePattern() {
  }
}