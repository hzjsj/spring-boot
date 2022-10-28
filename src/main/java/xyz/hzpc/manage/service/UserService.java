package xyz.hzpc.manage.service;

import org.springframework.stereotype.Repository;
import xyz.hzpc.manage.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author xiulong
* @description 针对表【user】的数据库操作Service
* @createDate 2022-10-28 09:23:34
*/
@Repository
public interface UserService extends IService<User> {


    /**
     * 自定义 mapper.xml 映射文件
     * 根据 id 查询用户信息为 map 集合
     * @param id
     * @return
     */
   // Map<String,Object> selectMapById(int id);
}
