package cn.kdsa.user.service;

import cn.kdsa.user.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
* @author xiulong
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2022-10-30 16:37:32
*/
@Repository
public interface UserService extends IService<User> {

  /**
   * md5 加密,混淆字符
   */
  String SALT = "salt...";

  User userLogin(String username, String password, HttpServletRequest request);

  User getSafetyUser(User originUser);

  int userLogout(HttpServletRequest request);

  int addUser(String username,String userAccount, String userPassword);

  int updateUser(Long id,String username,String userAccount, String userPassword);

  List<User> searchUsersByTages(List<String> tagNameList);

  List<User> searchUsersByTage(List<String> tagNameList);


  /**
   * 根据 id 查询用户信息为 map 集合
   * @param id
   * @return
   */
  Map<String,Object> selectMapById(Long id);

  void getByName(String name);
}
