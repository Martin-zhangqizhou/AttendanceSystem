package com.qz.modules.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.modules.system.entity.SysUserTokenEntity;
import com.qz.utils.R;

/**
 * 用户Token
 *
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
