package com.qz.modules.worker.dao;

import com.qz.modules.worker.entity.WorkUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qz.modules.worker.entity.WorkerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 普通用户
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-09 09:37:29
 */
@Mapper
public interface WorkUserDao extends BaseMapper<WorkUserEntity> {

    WorkUserEntity queryByUserName(@Param("username") String username);
}
