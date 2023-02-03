package cn.kdsa.user.controller;

import cn.kdsa.user.common.BaseResponse;
import cn.kdsa.user.common.ResultUtils;
import cn.kdsa.user.mapper.DoubanMapper;
import cn.kdsa.user.model.domain.Douban;
import cn.kdsa.user.model.domain.Types;
import cn.kdsa.user.service.DoubanService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/douban")
public class DoubanController {

  @Resource
  private DoubanService doubanService;

  @Resource
  private DoubanMapper doubanMapper;

  /**
   * 获取 douban 表全部数据
   * @return  json 格式
   */
  @GetMapping("/get")
  public BaseResponse<List<Douban>> getList(){
    List<Douban> result = doubanService.list();
    return ResultUtils.success(result);
  }

  /**
   * 分页获取 douban 表全部数据
   * @return  json 格式
   */
  @GetMapping("/page")
  public BaseResponse<Page<Douban>> getPage(HttpServletRequest request){
    long current = new Long(request.getParameter("current"));
    long size = 10;
    QueryWrapper<Douban> objectQueryWrapper = new QueryWrapper<>(null);
    Page<Douban> result = doubanService.page(new Page<>(current, size), objectQueryWrapper);
    return ResultUtils.success(result);
  }


  //  下面调用自己写的 SQL 语句

  /**
   * 注意接口 url 大小写问题
   * @param request
   * @return
   */
  @GetMapping("/getone")
  public BaseResponse<Douban> getOne(HttpServletRequest request){
    String name = request.getParameter("name");
    Douban result = doubanService.selectFind(name);
    return ResultUtils.success(result);
  }

  @GetMapping("/getall")
  public BaseResponse<List<Douban>> selectAll(HttpServletRequest request){
    String name = request.getParameter("name");
    List<Douban> result = doubanService.selectAll(name);
    return ResultUtils.success(result);
  }

  @GetMapping("/getpage")
  public BaseResponse<Page<Douban>> selectPageVo(HttpServletRequest request){
    long current = new Long(request.getParameter("current"));
    Page<Douban> page = new Page<>(current, 10);
    //  第一个参数分页，第二个参数 查询条件
    Page<Douban> result = doubanMapper.selectPageVo(page, 0L);
    return ResultUtils.success(result);
  }

  @GetMapping("/sqllist")
  public BaseResponse<Page<Types>> selectPageList(HttpServletRequest request){
    long current = new Long(request.getParameter("current"));
    Page<Types> page = new Page<>(current, 10);
    //  第一个参数分页，第二个参数 查询条件
    Page<Types> result = doubanMapper.selectPageList(page);
    return ResultUtils.success(result);
  }
}
