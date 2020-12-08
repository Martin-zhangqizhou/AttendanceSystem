package com.qz.modules.worker.dao;

import com.qz.modules.worker.entity.CountEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 月统计表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@Mapper
public interface CountDao extends BaseMapper<CountEntity> {
	
}
