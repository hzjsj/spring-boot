package xyz.hzpc.manage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import xyz.hzpc.manage.model.domain.User;
import xyz.hzpc.manage.service.UserService;
import xyz.hzpc.manage.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author xiulong
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-10-28 09:23:34
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




