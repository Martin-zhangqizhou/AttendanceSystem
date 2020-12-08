package com.qz.modules.app.controller;

import com.qz.modules.app.form.RegisterForm;
import com.qz.modules.app.entity.UserEntity;
import com.qz.modules.app.service.UserService;
import com.qz.utils.R;
import com.qz.validator.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import static org.apache.commons.codec.digest.DigestUtils.*;

//注册用户
@RestController
@RequestMapping("/app")
//APP注册接口
public class AppRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    //注册
    public R register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getMobile());
        user.setPassword(sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.save(user);

        return R.ok();
    }
}
