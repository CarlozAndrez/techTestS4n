package com.s4n.foodDelivery.adapters;

import static com.s4n.foodDelivery.application.constants.CommonConstants.INPUT_FOLDER;
import static com.s4n.foodDelivery.application.constants.CommonConstants.MAX_DRONES_AVAILABLE;
import static com.s4n.foodDelivery.application.constants.CommonConstants.MAX_LUNCHES_PER_DRONE;
import static com.s4n.foodDelivery.application.constants.CommonConstants.REG_EX_TO_VERIFY_FILE_NAME;

import com.s4n.foodDelivery.application.exceptions.DeliveryManagerException;
import com.s4n.foodDelivery.domain.DroneRoute;
import com.s4n.foodDelivery.ports.driven.DeliveryReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadFromFlatFileAdapter implements DeliveryReader {

  public List<DroneRoute> readDeliveryInformation(String pathName) {
    File file = new File(pathName);
    String[] pathNames = file.list();
    validateMaximumDronesAvailable(pathNames);
    List<DroneRoute> droneRoutes = new ArrayList<>();
    try {
      for (String fileName : pathNames) {
        if (verifyFileNamePattern(REG_EX_TO_VERIFY_FILE_NAME, fileName)) {
          DroneRoute droneRoute = new DroneRoute();
          droneRoute.setDroneID(getDroneID(fileName));
          droneRoute
              .setDeliveryInstructions(getDeliveryInstructionsFromFlatFile(pathName + fileName));
          validateMaximumLunchesByDrone(droneRoute);
          droneRoutes.add(droneRoute);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      throw new DeliveryManagerException(100L,
          String.format("Error reading route files from %s ", INPUT_FOLDER));
    }
    return droneRoutes;
  }

  private List<String> getDeliveryInstructionsFromFlatFile(String pathName) throws IOException {
    List<String> listOfInstructions = new LinkedList<>();
    File routeFile = new File(pathName);
    FileReader fileReader = new FileReader(routeFile);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      listOfInstructions.add(line);
    }
    bufferedReader.close();
    fileReader.close();
    return listOfInstructions;
  }

  private void validateMaximumDronesAvailable(String[] pathNames) {
    if (pathNames.length > MAX_DRONES_AVAILABLE) {
      throw new DeliveryManagerException(100L, String.format(
          "The system can only control %d drones at the same time", MAX_DRONES_AVAILABLE));
    }
  }

  private void validateMaximumLunchesByDrone(DroneRoute droneRoute) {
    if (droneRoute.getDeliveryInstructions().size() > MAX_LUNCHES_PER_DRONE) {
      throw new DeliveryManagerException(100L, String.format(
          "A drone can only carry %d lunches per route, if you want to carry more lunches "
              + "please modify the value of maximum lunches allowed", MAX_LUNCHES_PER_DRONE));
    }
  }

  private String getDroneID(String pathname) {
    return pathname.replaceAll("\\D+", "");
  }

  private static boolean verifyFileNamePattern(String regExToVerifyFileName, String pathname) {
    Pattern pattern = Pattern.compile(regExToVerifyFileName);
    return pattern.matcher(pathname).matches();
  }
}