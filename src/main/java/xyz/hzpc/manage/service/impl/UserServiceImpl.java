package xyz.hzpc.manage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import xyz.hzpc.manage.model.domain.User;
import xyz.hzpc.manage.service.UserService;
import xyz.hzpc.manage.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 *
* @author xiulong
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-10-28 09:23:34
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Override
    public long addUser(String name, Integer age, String email) {

        // 1. 校验是否为空
        if (StringUtils.isAllBlank(name,email)){
            return -1;
        }

        // 2. 判断用户名长度
        if (name.length()<4){
            return -2;
        }

        // 3. 用户名不能重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);
        long count = this.count(queryWrapper);
        if (count>0){
            return -3;
        }

        // 4. 插入数据
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // ServiceImpl 中自带类 service 类，下面用 this
        boolean saveResult = this.save(user);
        if(!saveResult){
            return -4;
        }

        return user.getId();
    }
}




