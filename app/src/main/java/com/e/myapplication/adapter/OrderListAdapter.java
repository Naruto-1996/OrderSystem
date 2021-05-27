package com.e.myapplication.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.e.myapplication.R;
import com.e.myapplication.databinding.ItemOrderListBinding;
import com.e.myapplication.model.Order;
import com.e.myapplication.ui.ListDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

  // 数据源
  private List<Order> orderList;

  // 设置数据源
  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
    // 当数据发生改变时更新页面
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    // 加载布局文件
    ItemOrderListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_order_list, parent,false);
    return new ViewHolder(binding.getRoot());
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    // 当布局文件被绑定时可以处理一些事情 比如点击事件、页面跳转等
    ItemOrderListBinding binding = DataBindingUtil.getBinding(holder.itemView);
    binding.executePendingBindings();
    // 给页面绑定数据源
    binding.setData(orderList.get(position));
    // 订单列表中的某个item点击事件
    binding.orderLinear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 点击之后跳转到详情页面 并将数据传递过去
        Intent intent = new Intent(holder.itemView.getContext(), ListDetailActivity.class);
        intent.putExtra("id", String.valueOf(orderList.get(position).getId()));
        intent.putExtra("orderId", orderList.get(position).getOrderId());
        intent.putExtra("createdAt", orderList.get(position).getCreatedAt());
        intent.putExtra("state", orderList.get(position).getOrderState());
        holder.itemView.getContext().startActivity(intent);
      }
    });
  }

  @Override
  public int getItemCount() {
    return orderList == null ? 0 : orderList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }
}
