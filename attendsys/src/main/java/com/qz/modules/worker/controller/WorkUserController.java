package com.qz.modules.worker.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


import com.qz.modules.worker.form.WorkerLoginForm;
import com.qz.modules.worker.form.WorkerLogoutForm;
import com.qz.modules.worker.service.WorkerUserTokenService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qz.modules.worker.entity.WorkUserEntity;
import com.qz.modules.worker.service.WorkUserService;
import com.qz.utils.PageUtils;
import com.qz.utils.R;



/**
 * 普通用户
 *
 * @author qz
 * @email qzgarden@tju.edu.cn
 * @date 2020-12-09 09:37:29
 */
@RestController
@RequestMapping("worker/workuser")
public class WorkUserController extends AbstractController{
    @Autowired
    private WorkUserService workUserService;
    @Autowired
    private WorkerUserTokenService workerUserTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("worker:workuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = workUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{workerId}")
    @RequiresPermissions("worker:workuser:info")
    public R info(@PathVariable("workerId") Long workerId){
		WorkUserEntity workUser = workUserService.getById(workerId);

        return R.ok().put("workUser", workUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("worker:workuser:save")
    public R save(@RequestBody WorkUserEntity workUser){
		workUserService.saveUser(workUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("worker:workuser:update")
    public R update(@RequestBody WorkUserEntity workUser){
		workUserService.updateById(workUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("worker:workuser:delete")
    public R delete(@RequestBody Long[] workerIds){
		workUserService.removeByIds(Arrays.asList(workerIds));

        return R.ok();
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody WorkerLoginForm form)throws IOException {
        //用户信息
        WorkUserEntity user = workUserService.queryByUserName(form.getUsername());


        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            return R.error("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
            return R.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        R r = workerUserTokenService.createToken(user.getWorkerId());
        return r;
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public R logout(@RequestBody WorkerLogoutForm logoutForm) {
        //workerUserTokenService.logout(logoutForm.getWorkerId());
        workerUserTokenService.removeById(logoutForm.getWorkerId());
        return R.ok("成功登出！");
//        return logoutForm.getWorkerId();
    }

}
