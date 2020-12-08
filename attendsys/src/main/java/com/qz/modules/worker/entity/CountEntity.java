package com.qz.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 月统计表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@Data
@TableName("count")
public class CountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@TableId
	private Integer countId;
	/**
	 * 
	 */
	private Integer workerId;
	/**
	 * 
	 */
	private Integer workNote;
	/**
	 * 
	 */
	private Integer outNote;
	/**
	 * 
	 */
	private Integer overNote;
	/**
	 * 
	 */
	private Integer offNote;

}
