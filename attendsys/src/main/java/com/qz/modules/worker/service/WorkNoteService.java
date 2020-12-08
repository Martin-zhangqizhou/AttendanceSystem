package com.qz.modules.worker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qz.utils.PageUtils;
import com.qz.modules.worker.entity.WorkNoteEntity;

import java.util.Map;

/**
 * 出勤记录表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:24:15
 */
public interface WorkNoteService extends IService<WorkNoteEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

