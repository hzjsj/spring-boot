package cn.kdsa.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kdsa.user.model.domain.Douban;
import cn.kdsa.user.service.DoubanService;
import cn.kdsa.user.mapper.DoubanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author xiulong
* @description 针对表【douban(豆瓣 top250)】的数据库操作Service实现
* @createDate 2023-02-01 10:21:39
*/
@Service
public class DoubanServiceImpl extends ServiceImpl<DoubanMapper, Douban>
    implements DoubanService{

    @Resource
    private DoubanMapper doubanMapper;

    @Override
    public Douban selectFind(String name) {

      return doubanMapper.selectFind(name);
    }

  @Override
  public List<Douban> selectAll(String name) {

    return doubanMapper.selectAll(name);
  }
}




