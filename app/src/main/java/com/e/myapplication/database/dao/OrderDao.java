package com.e.myapplication.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.e.myapplication.model.Order;

import java.util.List;

@Dao
public interface OrderDao {

  // 获取所有订单
  @Query("SELECT * FROM `order` ORDER BY id DESC")
  List<Order> getAllOrders();


  // 更新某个订单
  @Update
  void updateOrder(Order order);

  // 插入订单
  @Insert
  void insertOrder(Order... orders);

  // 删除所有订单
  @Query("DELETE FROM `order`")
  void deleteAll();

  // 根据id找到某一个订单
  @Query("SELECT * FROM `order` WHERE id LIKE :id LIMIT 1")
  Order findOrderById(int id);

  // 删除单个订单
  @Delete
  void delete(Order order);
}
