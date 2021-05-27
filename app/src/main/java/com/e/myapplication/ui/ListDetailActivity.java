package com.e.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.e.myapplication.R;
import com.e.myapplication.base.BaseApplication;
import com.e.myapplication.databinding.ActivityListDetailBinding;
import com.e.myapplication.model.Order;
import com.hjq.toast.ToastUtils;

public class ListDetailActivity extends AppCompatActivity {

  private ActivityListDetailBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_list_detail);
    // 初始化点击事件
    initListener();
    initData();
  }


  // 获取数据
  private void initData() {
    // 获取从列表页面跳转时传递过来的数据
    String id = getIntent().getStringExtra("id");
    String orderId = getIntent().getStringExtra("orderId");
    String createdAt = getIntent().getStringExtra("createdAt");
    String state = getIntent().getStringExtra("state");
    binding.id.setText(id);
    binding.orderId.setText(orderId);
    binding.createdAt.setText(createdAt);
    binding.state.setText(state);
  }

  private void initListener() {
    binding.save.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (binding.orderId.getText().toString().isEmpty()) {
          ToastUtils.show("订单id是空的");
          return;
        }
        if (binding.createdAt.getText().toString().isEmpty()) {
          ToastUtils.show("时间是空的");
          return;
        }
        if (binding.state.getText().toString().isEmpty()) {
          ToastUtils.show("状态是空的");
          return;
        }
        // 更新之前先找到这个订单
        Order order = BaseApplication.myDataBase.getOrderDao().findOrderById(Integer.parseInt(getIntent().getStringExtra("id")));
        if (order!= null){
          // 给找的的订单赋值
          order.setOrderId(binding.orderId.getText().toString());
          order.setCreatedAt(binding.createdAt.getText().toString());
          order.setOrderState(binding.state.getText().toString());
          // 操作数据表 更新这个订单
          BaseApplication.myDataBase.getOrderDao().updateOrder(order);
        }
        ToastUtils.show("更新成功!");
        finish();
      }
    });

    binding.delete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 根据传递过来的这个订单详情在数据表中的 id 找到这个订单
        Order order = BaseApplication.myDataBase.getOrderDao().findOrderById(Integer.parseInt(getIntent().getStringExtra("id")));
        if (order != null) {
          // 如果找到了
          BaseApplication.myDataBase.getOrderDao().delete(order);
          ToastUtils.show("订单删除成功");
          // 关闭页面并回到订单列表页面
          finish();
        }else {
          ToastUtils.show("订单删除失败");
        }
      }
    });

    binding.back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }


}