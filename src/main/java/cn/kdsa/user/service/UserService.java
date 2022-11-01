package cn.kdsa.user.service;

import cn.kdsa.user.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author xiulong
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2022-10-30 16:37:32
*/
public interface UserService extends IService<User> {


  User userLogin(String username, String password, HttpServletRequest request);

  User getSafetyUser(User originUser);

  int userLogout(HttpServletRequest request);
}
