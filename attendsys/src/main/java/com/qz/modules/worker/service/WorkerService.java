package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.WorkerEntity;

import java.util.Map;

/**
 * 
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:15:30
 */
public interface WorkerService extends IService<WorkerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

