package com.qz.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qz.modules.system.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
