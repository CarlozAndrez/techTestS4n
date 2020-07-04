package com.s4n.foodDelivery;

import static com.s4n.foodDelivery.application.constants.CommonConstants.INPUT_FOLDER;

import com.s4n.foodDelivery.adapters.ReadFromFlatFileAdapter;
import com.s4n.foodDelivery.application.exceptions.DeliveryManagerException;
import com.s4n.foodDelivery.domain.service.DeliveryManager;
import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliveryMain {

  private static final Logger log = LoggerFactory.getLogger(DeliveryMain.class);

  public static void main(String[] args) {
    BasicConfigurator.configure();
    DeliveryManager deliveryManager = new DeliveryManager();
    ReadFromFlatFileAdapter readerAdapter = new ReadFromFlatFileAdapter();
    try {
      deliveryManager
          .ingestDroneDeliveryInformation(readerAdapter.readDeliveryInformation(INPUT_FOLDER));
    } catch (IOException e) {
      log.error("Error trying to read the input files", e);
      throw new DeliveryManagerException(200L, "Error trying to read the input files");
    }
  }
}
