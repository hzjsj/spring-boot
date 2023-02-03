package cn.kdsa.user.service;

import cn.kdsa.user.mapper.DoubanMapper;
import cn.kdsa.user.model.domain.Douban;
import cn.kdsa.user.model.domain.Types;
import cn.kdsa.user.model.domain.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class DoubanServeiceTest {

  @Resource
  private DoubanMapper doubanMapper;

  @Resource
  private DoubanService doubanService;

  @Test
  void selectSimple(){
    Douban result = doubanMapper.selectFind("红楼梦");
    System.out.println(result);
  }

  @Test
  void selectFind(){
    Douban result = doubanService.selectFind("红楼梦");
    System.out.println("result");
    System.out.println(result);
  }

  @Test
  void selectAll(){
    List<Douban> result = doubanMapper.selectAll("红");

    System.out.println(result);
  }

  @Test
  void selectPageVo(){
    Page<Douban> page = new Page<>(2, 3);
    //  第一个参数分页，第二个参数 查询条件
    doubanMapper.selectPageVo(page,0L);
    System.out.println(page);
  }

  // 废掉的，别看啦
  @Test
  void selectPageVos(){
    IPage<Douban> page = new Page<>(2, 3);
    doubanMapper.selectPageVo((Page<Douban>) page,10L);
    //  第一个参数分页，第二个参数 查询条件
    System.out.println(page);
  }

  // 2月2日写多表查询 sql 语句
  @Test
  void selectDouban(){

    Page<Types> page = new Page<>(2, 3);
    Page<Types> result = doubanMapper.selectPageList(page);
    System.out.println(result);
  }
}
