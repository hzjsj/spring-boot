package xyz.hzpc.manage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.hzpc.manage.model.domain.User;

import javax.annotation.Resource;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void testAddUser(){
        User user = new User();
        user.setName("testAddUser");
        user.setAge(10);
        user.setEmail("xxx@qq.com");
        boolean result = userService.save(user);
        Assertions.assertTrue(result);
        System.out.println(user);
    }

    // 测试自定义添加用户逻辑
    @Test
    void addUser(){
        long result = userService.addUser("lisi", 29, "xxx@xx.com");
        System.out.println(result);
    }
}