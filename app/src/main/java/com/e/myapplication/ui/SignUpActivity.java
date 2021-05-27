package com.e.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.e.myapplication.R;
import com.e.myapplication.base.BaseApplication;
import com.e.myapplication.databinding.ActivitySignUpBinding;
import com.e.myapplication.model.User;
import com.hjq.toast.ToastUtils;

public class SignUpActivity extends AppCompatActivity {

  private ActivitySignUpBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

    // 初始化点击事件
    initListener();
  }

  private void initListener() {
    binding.signUp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // 获取用户名和密码输入框的值
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();

        // 判断为空的情况
        if (username.isEmpty()) {
          // 消息提示
          ToastUtils.show("用户名为空");
        } else if (password.isEmpty()) {
          ToastUtils.show("密码为空");
        } else {
          // 都有值得话就往数据库User表中插入一条数据
          BaseApplication.myDataBase.getUserDao().insertUser(new User(username, password));
          ToastUtils.show("注册成功");
          // 注册成功后关闭这个页面 会跳转到登录页
          finish();
        }
      }
    });
  }

}