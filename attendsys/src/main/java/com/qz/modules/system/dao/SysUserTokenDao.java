package com.qz.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qz.modules.system.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysUserTokenDao extends BaseMapper<SysUserTokenEntity> {

    SysUserTokenEntity queryByToken(String token);
	
}
