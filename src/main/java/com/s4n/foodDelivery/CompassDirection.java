package com.s4n.foodDelivery;

public enum CompassDirection {
  Y_PLUS {
    public DeliveryPoint applyMovement(DeliveryPoint toNorth) { toNorth.setY(toNorth.getY()+1); return toNorth; }
  },
  Y_MINUS {
    public DeliveryPoint applyMovement(DeliveryPoint toSouth) { toSouth.setY(toSouth.getY()-1); return toSouth; }
  },
  X_PLUS {
    public DeliveryPoint applyMovement(DeliveryPoint toEast) { toEast.setX(toEast.getX()+1); return toEast; }
  },
  X_MINUS {
    public DeliveryPoint applyMovement(DeliveryPoint toWest) { toWest.setX(toWest.getX()-1); return toWest; }
  },
  ;

  public abstract DeliveryPoint applyMovement(DeliveryPoint deliveryPoint);
}
