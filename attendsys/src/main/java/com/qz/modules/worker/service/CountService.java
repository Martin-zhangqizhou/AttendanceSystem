package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.CountEntity;

import java.util.Map;

/**
 * 月统计表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
public interface CountService extends IService<CountEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

