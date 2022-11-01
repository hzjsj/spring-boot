package cn.kdsa.user.service;

import cn.kdsa.user.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

  @Resource
  private UserService userService;

  @Test
  void testAddUser(){
    User user = new User();
    user.setUsername("管理员");
    user.setUserAccount("123456");
    user.setAvatarUrl("xxx");
    user.setGender(20);
    user.setUserPassword(testDigest());
    boolean result = userService.save(user);
    Assertions.assertTrue(result);

    System.out.println(result);
  }

  /**
   * Spring 自带加密类
   */
  @Test
  String testDigest(){

    //  md5 单向非对称加密
    final String SALT = "salt...";
    String newPassword = DigestUtils.md5DigestAsHex((SALT+ "123456").getBytes());
    System.out.println(newPassword);
    return newPassword;
  }
}
