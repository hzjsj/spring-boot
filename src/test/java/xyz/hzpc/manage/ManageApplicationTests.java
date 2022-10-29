package xyz.hzpc.manage;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class ManageApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * Spring 自带加密类
     */
    @Test
    void testDigest(){

        //  md5 单向非对称加密
        final String SALT = "salt...";
        String newPassword = DigestUtils.md5DigestAsHex((SALT+ "password").getBytes());
        System.out.println(newPassword);
    }

}
