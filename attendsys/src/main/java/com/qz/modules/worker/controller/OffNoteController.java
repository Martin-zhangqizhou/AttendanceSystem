package com.qz.modules.worker.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.qz.modules.worker.entity.ApproveEntity;
import com.qz.modules.worker.entity.MangerApproveEntity;
import com.qz.modules.worker.service.ApproveService;
import com.qz.modules.worker.service.MangerApproveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qz.modules.worker.entity.OffNoteEntity;
import com.qz.modules.worker.service.OffNoteService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 请假记录表
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-08 10:21:09
 */
@RestController
@RequestMapping("worker/offnote")
public class OffNoteController {
    @Autowired
    private OffNoteService offNoteService;
    @Autowired
    private MangerApproveService mangerApproveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:offnote:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = offNoteService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{offNum}")
    @RequiresPermissions("worker:offnote:info")
    public R info(@PathVariable("offNum") Integer offNum){
		OffNoteEntity offNote = offNoteService.getById(offNum);

        return R.ok().put("offNote", offNote);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:offnote:save")
    public R save(@RequestBody OffNoteEntity offNote){
		offNoteService.save(offNote);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:offnote:update")
    public R update(@RequestBody OffNoteEntity offNote){
		offNoteService.updateById(offNote);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:offnote:delete")
    public R delete(@RequestBody Integer[] offNums){
		offNoteService.removeByIds(Arrays.asList(offNums));

        return R.ok();
    }

    /**
     * 请假
     * @param offNoteEntity
     * @return
     */
    @PostMapping("/off")
    public R off(@RequestBody OffNoteEntity offNoteEntity){
        System.out.println(offNoteEntity.toString());
        int days  = offNoteEntity.getOffDays();
        if (days <= 3){
            offNoteService.save(offNoteEntity);
            return R.ok().put("message", "请假成功");

        }else {
            process(offNoteEntity);
//            return R.error("已转交给管理员");
            MangerApproveEntity mae = MangerApproveEntity.builder().offTime(offNoteEntity.getOffTime()).endTime(offNoteEntity.getOffEnd()).offId(offNoteEntity.getWorkerId()).build();
            mae.setRatified(0);
            mangerApproveService.save(mae);
            return R.error(201, "转交管理员");
        }
    }

    /**
     * 转发给管理员
     * @param offNoteEntity
     */
    private R process(OffNoteEntity offNoteEntity) {
        int offDays = offNoteEntity.getOffDays();
        Date startDate = offNoteEntity.getOffTime();
        Date endDate = offNoteEntity.getOffEnd();
        return R.ok("开始时间是" + startDate.toString() + "\n" + "结束时间是" + endDate.toString());
    }
}
