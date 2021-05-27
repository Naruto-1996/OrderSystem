package com.e.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.e.myapplication.database.dao.OrderDao;
import com.e.myapplication.database.dao.UserDao;
import com.e.myapplication.model.Order;
import com.e.myapplication.model.User;

// 有几个表就将表的实体类放进来
@Database(entities = {Order.class, User.class}, version = 1, exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

  // 创建的数据库名称
  private static final String DATABASE_NAME = "my_database";

  private static MyDataBase databaseInstance;

  public static synchronized MyDataBase getInstance(Context context) {
    if (databaseInstance == null) {
      databaseInstance = Room
        .databaseBuilder(context.getApplicationContext(), MyDataBase.class, DATABASE_NAME)
        // 允许主线程进行查询
        .allowMainThreadQueries()
        .build();
    }
    return databaseInstance;
  }

  // 订单接口 用户获取数据库层的定义的 增删查改方法
  public abstract OrderDao getOrderDao();

  // 用户接口
  public abstract UserDao getUserDao();
}
