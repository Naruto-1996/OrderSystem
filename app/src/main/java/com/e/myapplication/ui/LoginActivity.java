package com.e.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.e.myapplication.R;
import com.e.myapplication.base.BaseApplication;
import com.e.myapplication.databinding.ActivityLoginBinding;
import com.e.myapplication.model.User;
import com.hjq.toast.ToastUtils;


public class LoginActivity extends AppCompatActivity {

  private ActivityLoginBinding binding;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

    // 初始化点击事件
    initListener();
  }


  private void initListener() {
    // 去注册文本的点击事件
    binding.signUp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
      }
    });
    binding.login.setOnClickListener(new View.OnClickListener() {
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
          // 通过用户名和密码去找这个用户
          User user = BaseApplication.myDataBase.getUserDao().findByUserNameAndPassword(username, password);
          if (user != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
            ToastUtils.show("登录成功");
          } else {
            ToastUtils.show("登录失败");
          }
        }
      }
    });
  }


}