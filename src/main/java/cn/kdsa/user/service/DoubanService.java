package cn.kdsa.user.service;

import cn.kdsa.user.model.domain.Douban;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author xiulong
* @description 针对表【douban(豆瓣 top250)】的数据库操作Service
* @createDate 2023-02-01 10:21:39
*/
public interface DoubanService extends IService<Douban> {

  /**
   * sql 语句查询一条数据
   * @param name
   * @return
   */
  Douban selectFind(String name);

  /**
   * sql 语句查询全部数据
   * @param name
   * @return
   */
  List<Douban> selectAll(String name);
}
