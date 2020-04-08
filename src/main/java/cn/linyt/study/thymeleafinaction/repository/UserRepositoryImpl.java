package cn.linyt.study.thymeleafinaction.repository;

import cn.linyt.study.thymeleafinaction.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName UserRepositoryImpl
 * @Description TODO
 * @Author Mojo
 * @Date 2020/3/24 22:10
 * @Version 1.0
 **/
@Repository
public class UserRepositoryImpl implements UserRepository {

    private static AtomicLong counter = new AtomicLong();
    private final ConcurrentMap<Long, User> userConcurrentMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if (id == null) { //新建
            id = counter.incrementAndGet();
            user.setId(id);
        }
        userConcurrentMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userConcurrentMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return userConcurrentMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<User>(userConcurrentMap.values());
    }
}
