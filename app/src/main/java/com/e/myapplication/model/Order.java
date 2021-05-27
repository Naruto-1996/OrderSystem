package com.e.myapplication.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// 订单实体类
@Entity
public class Order {
  // 主键
  @PrimaryKey(autoGenerate = true)
  private int id;
  // 订单编号
  @ColumnInfo(name = "order_id")
  private String orderId;
  // 订单创建时间
  @ColumnInfo(name = "created_at")
  private String createdAt;
  // 订单状态
  @ColumnInfo(name = "order_state")
  private String orderState;

  // 构造方法
  public Order( String orderId, String createdAt, String orderState) {
    this.orderId = orderId;
    this.createdAt = createdAt;
    this.orderState = orderState;
  }

  // setter 和 getter 方法
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getOrderState() {
    return orderState;
  }

  public void setOrderState(String orderState) {
    this.orderState = orderState;
  }
}
