package com.qz.modules.app.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
//注册表单
public class RegisterForm {
//    手机号
    @NotBlank(message="手机号不能为空")
    private String mobile;

//    密码
    @NotBlank(message="手机号不能为空")
    private String password;

}
