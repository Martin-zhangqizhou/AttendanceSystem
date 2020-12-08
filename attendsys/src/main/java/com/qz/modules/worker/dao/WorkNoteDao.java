package com.qz.modules.worker.dao;

import com.qz.modules.worker.entity.WorkNoteEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 出勤记录表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:24:15
 */
@Mapper
public interface WorkNoteDao extends BaseMapper<WorkNoteEntity> {
	
}
