package com.s4n.foodDelivery;

import static com.s4n.foodDelivery.application.constants.CommonConstants.INPUT_FOLDER;

import com.s4n.foodDelivery.adapters.ReadFromFlatFileAdapter;
import com.s4n.foodDelivery.domain.service.DeliveryManager;
import java.io.IOException;

public class DeliveryMain {

  public static void main(String[] args) {
    DeliveryManager deliveryManager = new DeliveryManager();
    ReadFromFlatFileAdapter readerAdapter = new ReadFromFlatFileAdapter();
    try {
      deliveryManager
          .ingestDroneDeliveryInformation(readerAdapter.readDeliveryInformation(INPUT_FOLDER));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
