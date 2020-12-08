package com.qz.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.modules.app.form.LoginForm;
import com.qz.modules.app.entity.UserEntity;


public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
}
