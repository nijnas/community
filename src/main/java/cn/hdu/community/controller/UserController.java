package cn.hdu.community.controller;

import cn.hdu.community.dto.Result;
import cn.hdu.community.entity.User;
import cn.hdu.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservice;
    @Autowired
    private HttpServletRequest httpServletRequest;

    /**
     * 用户登录接口
     *
     * @param userEmail
     * @param userPassword
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword) {
        User user = userservice.findAllByUserEmail(userEmail);
        if (user != null) {
            if (userPassword.equals(user.getUserPassword())) {
                HttpSession mySession = httpServletRequest.getSession();
                mySession.setAttribute("user", user);
                return Result.success("登录成功", user);
            } else {
                return Result.error("密码错误", "");
            }
        } else {
            return Result.error("用户不存在", "");
        }
    }

    /**
     * 用户注册接口
     *
     * @param userEmail
     * @param userPassword
     * @return
     */
    @PostMapping("/registered")
    public Result registered(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword) {
        if (userservice.existsUserByUserEmail(userEmail)) {
            return Result.error("该邮箱已注册", "");
        } else {
            if (userservice.userRegistered(userEmail, userPassword)) {
                return Result.success("注册成功", "");
            } else {
                return Result.error("注册失败，请重试", "");
            }
        }
    }

    /**
     * 用户注销接口
     *
     * @return
     */
    @RequestMapping("/cancellation")
    public Result cancellation() {
        HttpSession session = httpServletRequest.getSession(false);
        User user = (User) session.getAttribute("user");
        userservice.deleteUserByUserID(user.getId());
        if (!userservice.existsUserByUserEmail(user.getUserEmail())) {
            return Result.success("注销成功", "");
        } else {
            return Result.error("注销失败，请重试", "");
        }
    }
}
