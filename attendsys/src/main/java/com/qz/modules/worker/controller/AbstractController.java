package com.qz.modules.worker.controller;

import com.qz.modules.system.entity.SysUserEntity;
import com.qz.modules.worker.entity.WorkUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 *
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected WorkUserEntity getUser() {
		return (WorkUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getWorkerId();
	}
}
