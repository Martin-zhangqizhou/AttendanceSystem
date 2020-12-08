package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.ApproveEntity;

import java.util.Map;

/**
 * 批文表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 11:42:05
 */
public interface ApproveService extends IService<ApproveEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

