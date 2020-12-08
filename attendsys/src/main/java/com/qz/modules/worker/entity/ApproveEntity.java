package com.qz.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 批文表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 11:42:05
 */
@Data
@TableName("approve")
public class ApproveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer workerId;
	/**
	 * 
	 */
	private Integer offDays;
	/**
	 * 
	 */
	private Date offTime;
	/**
	 * 
	 */
	private Date offEnd;

	public ApproveEntity(Integer workerId, Integer offDays, Date offTime, Date offEnd) {
		this.workerId = workerId;
		this.offDays = offDays;
		this.offTime = offTime;
		this.offEnd = offEnd;
	}
}
