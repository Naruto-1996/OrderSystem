package com.e.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.e.myapplication.R;
import com.e.myapplication.base.BaseApplication;
import com.e.myapplication.databinding.ActivityMainBinding;
import com.e.myapplication.model.Order;
import com.hjq.toast.ToastUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    initListener();
  }


  private void initListener() {
    // 查看所有订单 点击事件
    binding.showAll.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, OrderListActivity.class);
        startActivity(intent);
      }
    });
    // 默认订单 点击事件
    binding.insertDefault.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        initData();
        ToastUtils.show("默认订单插入成功");
      }
    });
    // 插入单个订单 点击事件
    binding.insert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 跳转到插入页面
       startActivity(new Intent(MainActivity.this, InsertOrderActivity.class));
      }
    });
  }

  // 初始化默认订单数据
  private void initData() {
    Order order1 = new Order("XDDIFGEDFASDF", "2021-5-15", "已付款");
    Order order2 = new Order("XDDIFasdef", "2021-5-15", "未付款");
    Order order3 = new Order("asdfewvasdfe", "2021-5-15", "已付款");
    Order order4 = new Order("aefasvasefewf", "2021-5-15", "已付款");
    Order order5 = new Order("safewfasdfas", "2021-5-15", "未付款");
    Order order6 = new Order("asdfefasdf", "2021-5-15", "已付款");
    BaseApplication.myDataBase.getOrderDao().insertOrder(order1);
    BaseApplication.myDataBase.getOrderDao().insertOrder(order2);
    BaseApplication.myDataBase.getOrderDao().insertOrder(order3);
    BaseApplication.myDataBase.getOrderDao().insertOrder(order4);
    BaseApplication.myDataBase.getOrderDao().insertOrder(order5);
    BaseApplication.myDataBase.getOrderDao().insertOrder(order6);
  }


}