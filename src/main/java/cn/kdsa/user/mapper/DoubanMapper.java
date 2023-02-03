package cn.kdsa.user.mapper;

import cn.kdsa.user.model.domain.Douban;
import cn.kdsa.user.model.domain.Types;
import cn.kdsa.user.model.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author xiulong
* @description 针对表【douban(豆瓣 top250)】的数据库操作Mapper
* @createDate 2023-02-01 10:21:39
* @Entity cn.kdsa.user.model.domain.Douban
*/
public interface DoubanMapper extends BaseMapper<Douban> {
  Douban selectFind(String name);

  List<Douban> selectAll(String name);

  /**
   * 自定义 sql 语句，并使用分页插件
   * @param page  分页参数
   * @param id    查询条件
   * @return
   */
  Page<Douban> selectPageVo(Page<Douban> page,Long id);

  Page<Types> selectPageList(Page<Types> page);
}




