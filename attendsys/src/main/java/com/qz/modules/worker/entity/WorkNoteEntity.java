package com.qz.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 出勤记录表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:24:15
 */
@Data
@TableName("work_note")
public class WorkNoteEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	@TableId
	private Integer workerId;
	/**
	 * 
	 */
	private String workNum;
	/**
	 * 
	 */
	private Date workTim;
	/**
	 * 
	 */
	private Date endTim;
	/**
	 * 
	 */
	private Integer workDays;

}
