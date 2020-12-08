package com.qz.modules.worker.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 请假记录表
 * 
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@Data
@TableName("off_note")
public class OffNoteEntity implements Serializable {
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
	private Integer offNum;
	/**
	 * 
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date offTime;
	/**
	 * 
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date offEnd;
	/**
	 * 
	 */
	private Integer offDays;

}
