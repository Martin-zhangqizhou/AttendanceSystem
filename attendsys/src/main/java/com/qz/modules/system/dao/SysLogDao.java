package com.qz.modules.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qz.modules.system.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
