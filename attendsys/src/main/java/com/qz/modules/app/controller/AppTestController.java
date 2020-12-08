package com.qz.modules.app.controller;

import com.qz.modules.app.annotation.Login;
import com.qz.modules.app.annotation.LoginUser;
import com.qz.modules.app.entity.UserEntity;
import com.qz.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppTestController {

    @Login
    @GetMapping("userInfo")
//    获取用户信息
    public R userInfo(@LoginUser UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
//    获取用户ID
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
//    忽略Token验证测试
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }



}
