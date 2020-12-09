package com.qz.modules.worker.dao;

import com.qz.modules.system.entity.SysUserTokenEntity;
import com.qz.modules.worker.entity.WorkerUserTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 普通用户Token
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-09 10:23:17
 */
@Mapper
public interface WorkerUserTokenDao extends BaseMapper<WorkerUserTokenEntity> {

    WorkerUserTokenEntity queryByToken(String token);

    void saveEntity(WorkerUserTokenEntity tokenEntity);
}
