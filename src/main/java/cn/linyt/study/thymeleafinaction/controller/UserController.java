package cn.linyt.study.thymeleafinaction.controller;

import cn.linyt.study.thymeleafinaction.domain.User;
import cn.linyt.study.thymeleafinaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/3/24 22:58
 * @Version 1.0
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * @Method list
     * @Description TODO
     * 查询用户列表
     * @Author Mojo
     * @Date 2020/3/24 23:23
     * @Param [model]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUser());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * @Method view
     * @Description TODO
     * 根据id查询用户
     * @Author Mojo
     * @Date 2020/3/24 23:31
     * @Param [model, id]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/{id}")
    public ModelAndView view(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userRepository.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * @Method form
     * @Description TODO
     * 获取创建表单页面
     * @Author Mojo
     * @Date 2020/3/24 23:37
     * @Param [model]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * @Method saveOrUpdateUser
     * @Description TODO
     * 保存表单数据
     * @Author Mojo
     * @Date 2020/3/25 0:03
     * @Param [user]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @PostMapping
    public ModelAndView saveOrUpdateUser(User user) {
        user = userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * @Method deleteUser
     * @Description TODO
     * 根据id删除用户
     * @Author Mojo
     * @Date 2020/3/25 0:07
     * @Param [id]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userRepository.deleteUser(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * @Method modify
     * @Description TODO
     * 获取修改用户的页面
     * @Author Mojo
     * @Date 2020/3/25 0:11
     * @Param [id, model]
     * @Return org.springframework.web.servlet.ModelAndView
     **/
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getUserById(id));
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
