package com.e.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.e.myapplication.R;
import com.e.myapplication.base.BaseApplication;
import com.e.myapplication.databinding.ActivityInsertOrderBinding;
import com.e.myapplication.model.Order;
import com.hjq.toast.ToastUtils;

public class InsertOrderActivity extends AppCompatActivity {

  private ActivityInsertOrderBinding binding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_insert_order);

    initListener();
  }


  // 初始化点击事件
  private void initListener() {
    binding.back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    binding.insert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String orderId = binding.orderId.getText().toString();
        String createdAt = binding.createdAt.getText().toString();
        String state = binding.state.getText().toString();
        if (orderId.isEmpty()) {
          ToastUtils.show("订单id是空的");
        } else if (createdAt.isEmpty()) {
          ToastUtils.show("时间是空的");
        } else if (state.isEmpty()) {
          ToastUtils.show("状态是空的");
        } else {
          // 确保输入框都不为空 往数据表中插入一条数据
          BaseApplication.myDataBase.getOrderDao().insertOrder(new Order(orderId, createdAt, state));
          ToastUtils.show("插入成功!");
          finish();
        }
      }
    });
  }


}