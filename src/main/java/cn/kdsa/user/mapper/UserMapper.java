package cn.kdsa.user.mapper;

import cn.kdsa.user.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @author xiulong
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2022-10-30 16:37:32
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
  User selectByIdsimple(Long id);

  /**
   * 自定义 sql 语句
   * @param username
   * @return
   */
  User selectSimple(String username);

  /**
   * 自定义 sql 语句，并使用分页插件
   * @param page
   * @param id
   * @return
   */
  Page<User> selectPageVo(@Param("page") Page<User> page,@Param("id") Long id);
}




