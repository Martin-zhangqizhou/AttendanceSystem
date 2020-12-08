package com.qz.modules.app.form;

import lombok.Data;
import javax.validation.constraints.NotBlank;

//登陆需要的表单
@Data
//登录表单
public class LoginForm {
//    手机号
    @NotBlank(message="手机号不能为空")
    private String mobile;

//    密码
    @NotBlank(message="密码不能为空")
    private String password;

}
