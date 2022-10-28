package xyz.hzpc.manage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.hzpc.manage.mapper.UserMapper;
import xyz.hzpc.manage.model.domain.User;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class UserApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println("User Test");
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void select(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    /**
     * 测试更新
     * UPDATE user SET name=?, age=?, email=? WHERE id=?
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1585891369371611143L);
        user.setName("盗墓笔记啦啦啊");
        user.setAge(32);
        user.setEmail("daomu@qq.com");
        userMapper.updateById(user);
    }

    @Test
    public void testDelete() {
        // 1. 删除指定 ID
        int resultLine = userMapper.deleteById("1");
        Assert.assertEquals(1,resultLine);
        System.out.println(resultLine);
    }
}
