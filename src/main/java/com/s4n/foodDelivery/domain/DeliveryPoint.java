package com.s4n.foodDelivery.domain;

public class DeliveryPoint {

  private CartesianPositions direction;
  private int x;
  private int y;
  private String droneID;

  public DeliveryPoint(DeliveryPoint deliveryPoint) {
    this.direction = deliveryPoint.getDirection();
    this.x = deliveryPoint.getX();
    this.y = deliveryPoint.getY();
    this.droneID = deliveryPoint.getDroneID();
  }

  public DeliveryPoint(int x, int y, CartesianPositions direction, String droneID) {
    this.direction = direction;
    this.x = x;
    this.y = y;
    this.droneID = droneID;
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

  public CartesianPositions getDirection() {
    return direction;
  }

  public void setDirection(CartesianPositions direction) {
    this.direction = direction;
  }

  public String getDroneID() {
    return droneID;
  }

}
