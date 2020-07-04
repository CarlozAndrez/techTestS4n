package com.s4n.foodDelivery.application.exceptions;

public class DeliveryManagerException extends RuntimeException {

  private Long errorCode;
  private String errorDescription;

  public DeliveryManagerException(Long errorCode, String errorDescription) {
    super(errorDescription);
    this.initialize(errorCode, errorDescription);
  }

  private void initialize(Long errorCode, String errorDescription) {
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
  }

}

