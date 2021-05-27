package com.e.myapplication.base;

import android.app.Application;

import com.e.myapplication.database.MyDataBase;
import com.hjq.toast.ToastUtils;


// 项目启动时会先走这里 所以这个类经常会用来做一下初始化工作 比如初始化数据库对象 一些全局的常量之类的
public class BaseApplication extends Application {


  // 全局的MyDataBase对象
  public static MyDataBase myDataBase;



  @Override
  public void onCreate() {
    super.onCreate();

    // 初始化Database对象
    myDataBase = MyDataBase.getInstance(this);

    // 在 Application 中初始化 toast 消息提示
    ToastUtils.init(this);
  }



}
