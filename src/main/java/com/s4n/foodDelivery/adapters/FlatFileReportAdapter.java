package com.s4n.foodDelivery.adapters;

import static com.s4n.foodDelivery.application.constants.CommonConstants.GO_TO_NEXT_LINE;
import static com.s4n.foodDelivery.application.constants.CommonConstants.OUTPUT_FILE_FORMAT;
import static com.s4n.foodDelivery.application.constants.CommonConstants.OUTPUT_FOLDER;
import static com.s4n.foodDelivery.application.constants.CommonConstants.REPORT_TITLE;

import com.s4n.foodDelivery.application.exceptions.DeliveryManagerException;
import com.s4n.foodDelivery.domain.DeliveryPoint;
import com.s4n.foodDelivery.ports.driven.DeliveryReportPublisher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlatFileReportAdapter implements DeliveryReportPublisher {

  private static final Logger log = LoggerFactory.getLogger(FlatFileReportAdapter.class);

  @Override
  public void exportReport(List<DeliveryPoint> deliveryPoints) throws IOException {
    OutputStreamWriter outputStreamWriter = getOutputStreamWriter(deliveryPoints.get(0));
    addReportTitle(outputStreamWriter);
    deliveryPoints.stream().forEach(deliveryPoint -> {
      try {
        outputStreamWriter
            .write(deliveryPoint.getDirection().reportFormatter(deliveryPoint) + GO_TO_NEXT_LINE);
      } catch (IOException e) {
        String errorDescription = String.format("Error trying to create the output files", e);
        log.error(errorDescription, e);
        throw new DeliveryManagerException(300L, errorDescription);
      }
    });
    log.info(String.format("Delivery report for the drone %s was written ",
        deliveryPoints.get(0).getDroneID()));
    outputStreamWriter.close();
  }

  private void addReportTitle(OutputStreamWriter outputStreamWriter) throws IOException {
    outputStreamWriter.write(REPORT_TITLE + GO_TO_NEXT_LINE);
  }

  private OutputStreamWriter getOutputStreamWriter(DeliveryPoint deliveryPoint)
      throws FileNotFoundException {
    File reportFile = new File(
        OUTPUT_FOLDER + String.format(OUTPUT_FILE_FORMAT, deliveryPoint.getDroneID()));
    FileOutputStream fileOutputStream = new FileOutputStream(reportFile);
    return new OutputStreamWriter(fileOutputStream);
  }
}
