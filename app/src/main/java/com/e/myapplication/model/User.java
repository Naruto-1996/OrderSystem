package com.e.myapplication.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// 用户实体类
@Entity
public class User {
  // 主键
  @PrimaryKey(autoGenerate = true)
  private int id;
  // 用户名
  @ColumnInfo(name = "username")
  private String username;
  // 密码
  @ColumnInfo(name = "password")
  private String password;

  // 构造方法
  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }


  // getter 和 setter 方法

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
