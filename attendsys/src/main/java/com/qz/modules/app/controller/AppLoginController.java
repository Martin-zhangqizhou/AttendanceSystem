package com.qz.modules.app.controller;

import com.qz.modules.app.form.LoginForm;
import com.qz.modules.app.utils.JwtUtils;
import com.qz.modules.app.service.UserService;
import com.qz.utils.R;
import com.qz.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//app登陆授权
@RestController
@RequestMapping("/app")
//APP登录接口
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
//  登录
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        long userId = userService.login(form);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
