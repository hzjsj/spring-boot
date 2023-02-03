package cn.kdsa.user.service;

import cn.kdsa.user.mapper.UserMapper;
import cn.kdsa.user.model.domain.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceTest {

  @Resource
  private UserService userService;

  @Resource
  private UserMapper userMapper;

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


  @Test
  void testSearchUsersByTages(){
    List<String> tagNameList = Arrays.asList("java", "python");
    List<User> userList = userService.searchUsersByTages(tagNameList);
    Assert.assertNotNull(userList);
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

  @Test
  void testSelectIdSimple(){
    User user = userMapper.selectByIdsimple(2L);
    System.out.println(user);
  }

  @Test
  void testSelectIdSimple2(){
    User user = userMapper.selectSimple("xxxx");
    System.out.println(user);
  }

  @Test
  void getPages(){
    Page<User> page = new Page<>(10, 3);
    userMapper.selectPage(page,null);
    System.out.println(page);
  }

  @Test
  void selectPageVo(){
    Page<User> page = new Page<>(2, 3);
    userMapper.selectPageVo(page,25L);
    System.out.println(page);
  }
}
