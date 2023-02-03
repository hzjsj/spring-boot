package cn.kdsa.user.mapper;

import cn.kdsa.user.model.domain.Douban250;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author xiulong
* @description 针对表【douban250(豆瓣 top250)】的数据库操作Mapper
* @createDate 2023-02-01 08:52:16
* @Entity cn.kdsa.user.model.domain.Douban250
*/
public interface Douban250Mapper extends BaseMapper<Douban250> {
  Douban250 selectById(String name);
}




