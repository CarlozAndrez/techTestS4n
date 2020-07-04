package com.s4n.foodDelivery.domain;

import static com.s4n.foodDelivery.application.constants.CommonConstants.EAST_REPORT_MESSAGE;
import static com.s4n.foodDelivery.application.constants.CommonConstants.NORTH_REPORT_MESSAGE;
import static com.s4n.foodDelivery.application.constants.CommonConstants.SOUTH_REPORT_MESSAGE;
import static com.s4n.foodDelivery.application.constants.CommonConstants.WEST_REPORT_MESSAGE;

public enum CartesianPositions {
  Y_POSITIVE {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setY(forward.getY() + 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.setDirection(X_NEGATIVE);
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.setDirection(X_POSITIVE);
      return turnRight;
    }

    public String reportFormatter(DeliveryPoint deliveryPoint) {
      return "(" + deliveryPoint.getX() + ", " + deliveryPoint.getY()
          + NORTH_REPORT_MESSAGE;
    }
  },
  Y_NEGATIVE {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setY(forward.getY() - 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.setDirection(X_POSITIVE);
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.setDirection(X_NEGATIVE);
      return turnRight;
    }

    public String reportFormatter(DeliveryPoint deliveryPoint) {
      return "(" + deliveryPoint.getX() + ", " + deliveryPoint.getY()
          + SOUTH_REPORT_MESSAGE;
    }
  },
  X_POSITIVE {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setX(forward.getX() + 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.setDirection(Y_POSITIVE);
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.setDirection(Y_NEGATIVE);
      return turnRight;
    }

    public String reportFormatter(DeliveryPoint deliveryPoint) {
      return "(" + deliveryPoint.getX() + ", " + deliveryPoint.getY()
          + EAST_REPORT_MESSAGE;
    }
  },
  X_NEGATIVE {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setX(forward.getX() - 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.setDirection(Y_NEGATIVE);
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.setDirection(Y_POSITIVE);
      return turnRight;
    }

    public String reportFormatter(DeliveryPoint deliveryPoint) {
      return "(" + deliveryPoint.getX() + ", " + deliveryPoint.getY()
          + WEST_REPORT_MESSAGE;
    }
  };


  public abstract DeliveryPoint forward(DeliveryPoint deliveryPoint);

  public abstract DeliveryPoint left(DeliveryPoint deliveryPoint);

  public abstract DeliveryPoint right(DeliveryPoint deliveryPoint);

  public abstract String reportFormatter(DeliveryPoint deliveryPoint);

}
