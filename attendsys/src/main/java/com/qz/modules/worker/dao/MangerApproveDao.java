package com.qz.modules.worker.dao;

import com.qz.modules.worker.entity.MangerApproveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 19:13:05
 */
@Mapper
public interface MangerApproveDao extends BaseMapper<MangerApproveEntity> {

    void updateType(@Param("id") Integer id, @Param("ratified") Integer ratified);

}
