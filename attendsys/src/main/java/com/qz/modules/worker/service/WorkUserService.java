package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.modules.worker.entity.WorkerEntity;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.WorkUserEntity;

import java.util.Map;

/**
 * 普通用户
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-09 09:37:29
 */
public interface WorkUserService extends IService<WorkUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    WorkUserEntity queryByUserName(String username);

    void saveUser(WorkUserEntity workUser);
}

