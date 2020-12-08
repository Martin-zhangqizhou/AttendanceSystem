package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.MangerApproveEntity;

import java.util.Map;

/**
 * 
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 19:13:05
 */
public interface MangerApproveService extends IService<MangerApproveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

