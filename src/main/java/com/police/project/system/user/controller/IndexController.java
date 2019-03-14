package com.police.project.system.user.controller;

import com.police.framework.config.PoliceConfig;
import com.police.framework.web.controller.BaseController;
import com.police.project.system.menu.domain.Menu;
import com.police.project.system.menu.service.IMenuService;
import com.police.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 *
 * @author police
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private PoliceConfig policeConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", policeConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", policeConfig.getVersion());
        return "main";
    }
}
