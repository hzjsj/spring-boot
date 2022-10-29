package xyz.hzpc.manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;
import xyz.hzpc.manage.model.domain.User;

/**
 * 用户服务
 *
* @author xiulong
* @description 针对表【user】的数据库操作Service
* @createDate 2022-10-28 09:23:34
*/
@Repository
public interface UserService extends IService<User> {

    /**
     *
     * @param name  用户名
     * @param age   年龄
     * @param email 邮箱
     * @return
     */
    long addUser(String name,Integer age, String email);
}
