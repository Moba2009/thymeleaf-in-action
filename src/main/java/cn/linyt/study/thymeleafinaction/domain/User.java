package cn.linyt.study.thymeleafinaction.domain;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author Mojo
 * @Date 2020/3/24 21:30
 * @Version 1.0
 **/
@Data
public class User {

    private Long id;
    private String name;
    private String email;

    public User() {
    }

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
