package cn.linyt.study.thymeleafinaction.repository;

import cn.linyt.study.thymeleafinaction.domain.User;

import java.util.List;

/**
 * @InterfaceName UserRepository
 * @Description TODO
 * @Author Mojo
 * @Date 2020/3/24 21:36
 * @Version 1.0
 **/
public interface UserRepository {

    /**
     * @Method saveOrUpdateUser
     * @Description TODO
     * 创建或修改用户
     * @Author Mojo
     * @Date 2020/3/24 21:52
     * @Param [user]
     * @Return cn.linyt.study.thymeleafinaction.domain.User
     **/
    User saveOrUpdateUser(User user);

    /**
     * @Method deleteUser
     * @Description TODO
     * 删除用户
     * @Author Mojo
     * @Date 2020/3/24 21:54
     * @Param [id]
     * @Return void
     **/
    void deleteUser(Long id);

    /**
     * @Method getUserById
     * @Description TODO
     * 根据id查询用户
     * @Author Mojo
     * @Date 2020/3/24 21:56
     * @Param [id]
     * @Return cn.linyt.study.thymeleafinaction.domain.User
     **/
    User getUserById(Long id);

    /**
     * @Method listUser
     * @Description TODO
     * 获取用户列表
     * @Author Mojo
     * @Date 2020/3/24 22:01
     * @Param []
     * @Return java.util.List<cn.linyt.study.thymeleafinaction.domain.User>
     **/
    List<User> listUser();
    
}
