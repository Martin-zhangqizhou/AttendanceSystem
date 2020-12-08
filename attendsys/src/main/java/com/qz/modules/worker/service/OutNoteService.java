package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.OutNoteEntity;

import java.util.Map;

/**
 * 出差记录表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
public interface OutNoteService extends IService<OutNoteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

