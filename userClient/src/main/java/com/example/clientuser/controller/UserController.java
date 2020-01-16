package com.example.clientuser.controller;

import com.alibaba.fastjson.JSON;
import com.example.clientuser.service.PowerService;
import com.example.clientuser.service.RedisUserService;
import com.example.clientuser.service.UserService;
import com.example.common.entity.Power;
import com.example.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Date: 2019/10/9
 * Time: 10:32
 * Description: No Description
 *
 * @author:ZhouRunLin
 */

@Controller
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUserService redisUserService;

    @Autowired
    private PowerService powerService;

    @Value("${jar.upload.path}")
    private String jarPath;

    @Value("${static.resource.url}")
    private String staticServer;


    /*
     * 去jar包上传页面--携带uid,uname
     * */
    @RequestMapping("goto/iuploadJar")
    public String gotoUploadJar(Integer uid, Model model) {
        model.addAttribute("staticServer", staticServer);
        String uname = redisUserService.redisGet("user" + uid.toString());
        model.addAttribute("uname", uname);
        model.addAttribute("uid", uid);
        return "iframe/iuploadJar";
    }

    //selfJarManage
    @RequestMapping("goto/selfJarManage")
    public String gotoMyJarManage(Model model, Integer uid) {
        model.addAttribute("staticServer", staticServer);
        model.addAttribute("uid", uid);
        return "iframe/selfJarManage";
    }

    //iMy页面
    @RequestMapping("goto/iMy")
    public String gotoMy(Model model, Integer uid) {
        User user = userService.getUserByUid(uid);
        model.addAttribute("staticServer", staticServer);
        model.addAttribute("user", user);
        return "iframe/iMy";
    }

    //jar页面
    @RequestMapping("goto/jarRepository")
    public String gotoJar(Model model) {
        model.addAttribute("staticServer", staticServer);
        return "iframe/jarRepository";
    }

    //user页面
    @RequestMapping("goto/user")
    public String gotoTables(Model model) {
        model.addAttribute("staticServer", staticServer);
        return "iframe/user";
    }

    //jarManage页面
    @RequestMapping("goto/jarManage")
    public String gotoCharts(Model model) {
        model.addAttribute("staticServer", staticServer);
        return "iframe/jarManage";
    }

    //straw页面
    @RequestMapping("goto/straw")
    public String gotoForms(Model model) {
        model.addAttribute("staticServer", staticServer);
        return "iframe/straw";
    }


    /*
     * 注册功能
     * */
    @RequestMapping("goto/register")
    public String RegisterNewUser(@RequestParam("uname") String uname, @RequestParam("upassword") String upassword) {
        User user = new User();
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setStatus(0);
        user.setCreateDate(new Date());
        user.setUseruuid(MakeUUID());
        Integer num = userService.addNewUser(user);
        if (num > 0) {
            return "redirect:/User/toRegister/success";
        }
        return "redirect:/User/toRegister/error";
    }


    /*
     * 登录功能
     * 数据添加进redis实现数据共享：uid uname  --> powerID powerName
     * @PathVariable("username") String uname,@PathVariable("password") String upassword
     * */
    @RequestMapping("/goto/login")
    public String Login(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User securityUser = (org.springframework.security.core.userdetails.User) principal;
        User user = userService.getUserByUname(securityUser.getUsername());
        Power power = null;
        /**
         * 权限角色排序，取最高权限角色显示
         * SuperAmdin
         * NormalAdmin
         * NormalUser
         */
        power = user.getPowers().get(0);
        /**
         *  对redis进行主要数据预存操作
         *  redisHasKey 判断是否存在此key
         */
        Boolean bool = redisUserService.redisHasKey(user.getUid().toString());
        if (!bool) {
            //不存在则缓存
            redisUserService.redisSet("user" + user.getUid().toString(), user.getUname());
            redisUserService.redisSet("user" + user.getUid().toString() + "power" + power.getPowerID().toString(), power.getPowerName());
        }
        model.addAttribute("staticServer", staticServer);
        model.addAttribute("user", user);
        model.addAttribute("power", power);
        return "index";
    }


    /*
     * 去成功页面
     * */
    @RequestMapping("toRegister/success")
    public String gotoSuccess() {
        return "registersuccess";
    }

    /*
     * 去z注册异常页面
     * */
    @RequestMapping("toRegister/error")
    public String gotoError() {
        return "registererror";
    }

    /**
     * 去登录失败页面
     *
     * @return
     */
    @RequestMapping("toLogin/error")
    public String gotoLoginError() {
        return "loginError";
    }

    /*
     * 去登陆页面
     * */
    @RequestMapping("login")
    public String gotoLogin(Model model) {
        model.addAttribute("error","false");
        return "login";
    }

    /*
     * 去注册页面
     * */
    @RequestMapping("register")
    public String gotoRegister() {
        return "register";
    }

    @RequestMapping("/find/users")
    public void findUsers(HttpServletResponse resp) {
        List<User> list = userService.getAllUsers();
        try {
            resp.setContentType("text/html;charset=utf8;");
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除用户功能
     *
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> deleteUserByUID(@RequestParam("uid") Integer uid) {
        Map<String, String> map = new HashMap<>();
        Integer num = userService.moveUserByUid(uid);
        if (num > 0) {
            map.put("info", "已批准");
        } else {
            map.put("info", "批准异常");
        }
        return map;
    }

    @RequestMapping(value = "checkRegisterUname",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> checkRegisterUname(@RequestParam("uname") String uname){
        Map<String, String> map = new HashMap<>();
        User user=userService.getUserByUname(uname);
        if(user!=null){
            map.put("info","true");
        }else{
            map.put("info","false");
        }
        return map;
    }
    @RequestMapping("changePWD")
    @ResponseBody
    public Map<String, String> changePWD(@RequestParam("oldPWD") String oldPWD,
                                         @RequestParam("newPWD") String newPWD,
                                         @RequestParam("AgainNewPWD") String AgainNewPWD,
                                         @RequestParam("uid") Integer uid) {
        Map<String, String> map = new HashMap<>();
        User user = userService.getUserByUid(uid);
        if (newPWD.equals(AgainNewPWD)) {
            if (user.getUpassword().equals(oldPWD)) {
                Integer num = userService.updatePwd(newPWD, uid);
                if (num > 0) {
                    map.put("info", "修改成功!");
                }
            } else {
                map.put("info", "旧密码错误!");
            }
        } else {
            map.put("info", "两次密码不一致!");
        }
        return map;
    }

    public String MakeUUID() {
        UUID uuid = UUID.randomUUID();
        String uuNume = uuid.toString().replace("-", "");
        return uuNume;
    }

    //测试请求
    @RequestMapping("/SuperAdmin")
    @ResponseBody
    public String getSuperAdmin() {
        return "SuperAdmin";
    }

    @RequestMapping("/NormalAdmin")
    @ResponseBody
    public String getNormalAdmin() {
        return "NormalAdmin";
    }

    @RequestMapping("/NormalUser")
    @ResponseBody
    public String getNormalUser() {
        return "NormalUser";
    }


}
