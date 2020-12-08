package com.qz.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.modules.system.entity.SysLogEntity;
import com.qz.utils.PageUtils;

import java.util.Map;


/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
