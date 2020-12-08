package com.qz.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 19:13:05
 */
@Data
@TableName("manger_approve")
public class MangerApproveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer managerId;
	/**
	 * 
	 */
	private Integer offId;
	/**
	 * 
	 */
	private Integer ratified;

	private Date offTime;

	private Date endTime;

	public MangerApproveEntity(Integer offId, Date offTime, Date endTime) {
		this.offId = offId;
		this.offTime = offTime;
		this.endTime = endTime;
	}
}
