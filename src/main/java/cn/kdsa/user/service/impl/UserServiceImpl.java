package cn.kdsa.user.service.impl;

import cn.kdsa.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kdsa.user.model.domain.User;
import cn.kdsa.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static cn.kdsa.user.contant.UserContant.*;

/**
* @author xiulong
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2022-10-30 16:37:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

  @Resource
  private UserMapper userMapper;

  @Override
  public User userLogin(String username, String password, HttpServletRequest request) {

    // 1. 判断用户名和密码是否为空值
    if (StringUtils.isAllBlank(username,password)){
      return null;
    }

    // 2. md5 单向非对称加密
    final String SALT = "salt...";
    String newPassword = DigestUtils.md5DigestAsHex((SALT+ password).getBytes());

    // 3. 根据账号密码，去查询数据库
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("userAccount",username);
    queryWrapper.eq("userPassword",newPassword);
    User user = userMapper.selectOne(queryWrapper);

    // 4. 用户信息去除敏感信息
    User safetyUser = getSafetyUser(user);

    // 4. 记录用户的登入状态
    request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);

    return safetyUser;
  }

  @Override
  public User getSafetyUser(User originUser){
    if (originUser==null){
      return null;
    }
    User safetyUser = new User();
    safetyUser.setId(originUser.getId());
    safetyUser.setUsername(originUser.getUsername());
    safetyUser.setUserAccount(originUser.getUserAccount());
    safetyUser.setAvatarUrl(originUser.getAvatarUrl());
    safetyUser.setGender(originUser.getGender());
    safetyUser.setPhone(originUser.getPhone());
    safetyUser.setEmail(originUser.getEmail());
    safetyUser.setUserRole(originUser.getUserRole());
    safetyUser.setCreateTime(originUser.getCreateTime());
    return safetyUser;
  }

    @Override
    public int userLogout(HttpServletRequest request) {

      // 移除登录态
      request.getSession().removeAttribute(USER_LOGIN_STATE);
      return 200;
    }
}




