package com.e.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.e.myapplication.R;
import com.e.myapplication.adapter.OrderListAdapter;
import com.e.myapplication.base.BaseApplication;
import com.e.myapplication.databinding.ActivityOrderListBinding;
import com.hjq.toast.ToastUtils;

public class OrderListActivity extends AppCompatActivity {

  private ActivityOrderListBinding binding;
  private OrderListAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_order_list);
    // 初始化点击事件
    initListener();
    // 初始化recycleView循环列表
    initRecycleView();
  }


  private void initListener() {
    binding.back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    binding.deleteAll.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 删除所有订单
        BaseApplication.myDataBase.getOrderDao().deleteAll();
        ToastUtils.show("删除成功");
        // 删除成功之后，从数据库中找到所有的订单并给适配器赋值 更新页面显示
        adapter.setOrderList(BaseApplication.myDataBase.getOrderDao().getAllOrders());
      }
    });
  }


  private void initRecycleView() {
    // 创建适配器
     adapter = new OrderListAdapter();
    // 创建布局管理器 这里为线性布局
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    // 给recycleView 设置适配器和布局管理器
    binding.recycle.setLayoutManager(layoutManager);
    binding.recycle.setAdapter(adapter);
  }

  @Override
  protected void onResume() {
    super.onResume();
    // 从数据库中找到所有的订单并给适配器赋值
    adapter.setOrderList(BaseApplication.myDataBase.getOrderDao().getAllOrders());
  }
}