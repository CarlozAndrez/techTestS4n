package com.s4n.foodDelivery;

public class DeliveryPoint {

  int x;
  int y;
  CompassDirection direction;

  public DeliveryPoint(int x, int y, CompassDirection direction) {
    this.x = x;
    this.y = y;
    this.direction = direction;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public CompassDirection getDirection() {
    return direction;
  }

  public void setDirection(CompassDirection direction) {
    this.direction = direction;
  }

}
