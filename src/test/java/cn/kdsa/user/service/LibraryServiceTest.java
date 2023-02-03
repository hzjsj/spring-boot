package cn.kdsa.user.service;

import cn.kdsa.user.mapper.LibraryMapper;
import cn.kdsa.user.mapper.UserMapper;
import cn.kdsa.user.model.domain.Library;
import cn.kdsa.user.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LibraryServiceTest {

  @Resource
  private UserService userService;

  @Resource
  private UserMapper userMapper;

  @Resource
  private LibraryService libraryService;

  @Test
  void addBook(){
    Library library = new Library();
    library.setTitle("大数据");
    library.setIsbn("xxx");
    library.setPrice(10.1D);
    library.setRemarks("描述信息");

    boolean result = libraryService.save(library);

    System.out.println(result);
    System.out.println("1234569");
  }

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


}
