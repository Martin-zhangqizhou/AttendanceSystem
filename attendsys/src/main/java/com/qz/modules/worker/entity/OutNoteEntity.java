package com.qz.modules.worker.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 出差记录表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@Data
@TableName("out_note")
public class OutNoteEntity implements Serializable {
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
	private Integer outNum;
	/**
	 * 
	 */
	private Date outTime;
	/**
	 * 
	 */
	private Date backTime;
	/**
	 * 
	 */
	private Integer outDays;

}
