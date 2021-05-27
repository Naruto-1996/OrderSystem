package com.e.myapplication.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.e.myapplication.model.User;

@Dao
public interface UserDao {

  // 在user表中,根据用户名和密码进行查询一个用户
  @Query("SELECT * FROM user WHERE username LIKE :username AND password LIKE :password LIMIT 1")
  User findByUserNameAndPassword(String username, String password);

  // 在user表中,插入一个或多个用户
  @Insert
  void insertUser(User... users);

}
