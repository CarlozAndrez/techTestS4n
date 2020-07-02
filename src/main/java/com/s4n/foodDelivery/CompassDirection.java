package com.s4n.foodDelivery;

public enum CompassDirection {
  Y_PLUS {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setY(forward.getY() + 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.direction = X_MINUS;
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.direction = X_PLUS;
      return turnRight;
    }
  },
  Y_MINUS {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setY(forward.getY() - 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.direction = X_PLUS;
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.direction = X_MINUS;
      return turnRight;
    }
  },
  X_PLUS {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setX(forward.getX() + 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.direction = Y_PLUS;
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.direction = Y_MINUS;
      return turnRight;
    }
  },
  X_MINUS {
    public DeliveryPoint forward(DeliveryPoint forward) {
      forward.setX(forward.getX() - 1);
      return forward;
    }

    public DeliveryPoint left(DeliveryPoint turnLeft) {
      turnLeft.direction = Y_MINUS;
      return turnLeft;
    }

    public DeliveryPoint right(DeliveryPoint turnRight) {
      turnRight.direction = Y_PLUS;
      return turnRight;
    }
  };

  public abstract DeliveryPoint forward(DeliveryPoint deliveryPoint);

  public abstract DeliveryPoint left(DeliveryPoint deliveryPoint);

  public abstract DeliveryPoint right(DeliveryPoint deliveryPoint);

}
