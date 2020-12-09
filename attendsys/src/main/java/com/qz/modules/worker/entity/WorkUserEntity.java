package com.qz.modules.worker.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 普通用户
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-09 09:37:29
 */
@Data
@TableName("work_user")
public class WorkUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * (type = IdType.INPUT)必须要加上！！！！
	 */
	@TableId(value = "worker_id",type = IdType.INPUT)
	private Long workerId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 盐
	 */
	private String salt;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}
