package com.qz.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 加班表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@Data
@TableName("over_note")
public class OverNoteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Integer workerId;
	/**
	 * 
	 */
	@TableId
	private Integer overNum;
	/**
	 * 
	 */
	private Date overTime;
	/**
	 * 
	 */
	private Date overendTime;
	/**
	 * 
	 */
	private Integer overDays;

}
