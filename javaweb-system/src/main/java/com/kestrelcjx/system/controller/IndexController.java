package com.kestrelcjx.system.controller;

import com.kestrelcjx.common.config.CommonConfig;
import com.kestrelcjx.common.config.SystemConfig;
import com.kestrelcjx.common.utils.CommonUtils;
import com.kestrelcjx.common.utils.JsonResult;
import com.kestrelcjx.common.utils.StringUtils;
import com.kestrelcjx.system.dto.UpdatePasswordDto;
import com.kestrelcjx.system.dto.UpdateUserInfoDto;
import com.kestrelcjx.system.entity.Admin;
import com.kestrelcjx.system.mapper.AdminMapper;
import com.kestrelcjx.system.service.IAdminService;
import com.kestrelcjx.system.service.IMenuService;
import com.kestrelcjx.system.utils.ShiroUtils;
import com.kestrelcjx.system.vo.MenuListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 后台控制器
 */
@Controller
public class IndexController {
    @Autowired
    private IMenuService menuService;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private IAdminService adminService;

    /**
     * 列表页
     *
     * @param model
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {
        Admin admin = adminMapper.selectById(ShiroUtils.getAdminId());
        // 获取菜单
        List<MenuListVo> menuList = menuService.getNavbarMenu(ShiroUtils.getAdminId());
        model.addAttribute("menuList", menuList);
        // 用户信息
        admin.setAvatar(CommonUtils.getImageURL(admin.getAvatar()));
        model.addAttribute("user", admin);

        // 系统信息
        model.addAttribute("fullName", SystemConfig.fullName);
        model.addAttribute("nickName", SystemConfig.nickName);
        model.addAttribute("version", SystemConfig.version);
        return "index";
    }

    /**
     * 后台欢迎页
     *
     * @return
     */
    @GetMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 个人中心
     *
     * @return
     */
    @GetMapping("/userInfo")
    public String userInfo(Model model) {
        Map<String, Object> info = adminService.info(ShiroUtils.getAdminId());
        model.addAttribute("info", info);
        return "userInfo";
    }

    /**
     * 更新个人中心信息
     *
     * @param userInfoDto 参数
     * @return
     */
    @ResponseBody
    @PostMapping("/updateUserInfo")
    public JsonResult updateUserInfo(@RequestBody UpdateUserInfoDto userInfoDto) {
        if (CommonConfig.appDebug) {
            return JsonResult.error("演示环境禁止操作");
        }
        Admin entity = new Admin();
        entity.setId(ShiroUtils.getAdminId());
        entity.setNickname(userInfoDto.getNickname());
        entity.setEmail(userInfoDto.getEmail());
        entity.setIntro(userInfoDto.getIntro());
        entity.setAddress(userInfoDto.getAddress());
        Integer result = adminMapper.updateById(entity);
        if (result == 0) {
            return JsonResult.error("更新失败");
        }
        return JsonResult.success();
    }

    /**
     * 修改密码
     *
     * @param updatePasswordDto 参数
     * @return
     */
    @ResponseBody
    @PostMapping("/updatePassword")
    public JsonResult updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto) {
        if (CommonConfig.appDebug) {
            return JsonResult.error("演示环境禁止操作");
        }
        // 原密码校验
        if (StringUtils.isEmpty(updatePasswordDto.getOldPassword())) {
            return JsonResult.error("原密码不能为空");
        }
        // 新密码校验
        if (StringUtils.isEmpty(updatePasswordDto.getNewPassword())) {
            return JsonResult.error("新密码不能为空");
        }
        // 确认密码
        if (StringUtils.isEmpty(updatePasswordDto.getRePassword())) {
            return JsonResult.error("确认密码不能为空");
        }
        if (!updatePasswordDto.getNewPassword().equals(updatePasswordDto.getRePassword())) {
            return JsonResult.error("两次输入的密码不一致");
        }
        // 获取当前用户的密码
        Admin adminInfo = adminMapper.selectById(ShiroUtils.getAdminId());
        if (adminInfo == null) {
            return JsonResult.error("用户信息不存在");
        }
        if(!adminInfo.getPassword().equals(CommonUtils.password(updatePasswordDto.getOldPassword()))) {
            return JsonResult.error("密码错误");
        }
        if (!adminInfo.getStatus().equals(1)) {
            return JsonResult.error("您的信息已被禁用");
        }
        adminInfo.setPassword(CommonUtils.password(updatePasswordDto.getNewPassword()));
        Integer result = adminMapper.updateById(adminInfo);
        if (result == 0) {
            return JsonResult.error("密码修改失败");
        }
        return JsonResult.success("密码修改成功");
    }
}

