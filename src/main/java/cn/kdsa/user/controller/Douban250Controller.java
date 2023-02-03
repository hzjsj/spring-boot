package cn.kdsa.user.controller;

import cn.kdsa.user.common.BaseResponse;
import cn.kdsa.user.common.ResultUtils;
import cn.kdsa.user.model.domain.Douban;
import cn.kdsa.user.model.domain.Douban250;
import cn.kdsa.user.service.Douban250Service;
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
@RequestMapping("/api/250")
//@Validated
public class Douban250Controller {

  @Resource
  DoubanService doubanService;
  @GetMapping("/getPage")
  public BaseResponse<List<Douban>> getPage(){
    List<Douban> doubanList = doubanService.list();
    return ResultUtils.success(doubanList);
  }


  @Resource
  private Douban250Service douban250Service;

  @GetMapping("/get")
  public BaseResponse<List<Douban250>> getList(){
    List<Douban250> result = douban250Service.list();
    return ResultUtils.success(result);
  }

  @GetMapping("/getsql")
  public BaseResponse<List<Douban250>> getLists(){
    List<Douban250> result = douban250Service.list();
    return ResultUtils.success(result);
  }


  @GetMapping("/page")
  public BaseResponse<Page<Douban250>> getPage(HttpServletRequest request){
    long current = new Long(request.getParameter("current"));
    long size = 10;
    QueryWrapper<Douban250> objectQueryWrapper = new QueryWrapper<>(null);
    Page<Douban250> result = douban250Service.page(new Page<>(current, size), objectQueryWrapper);
    return ResultUtils.success(result);
  }
}
