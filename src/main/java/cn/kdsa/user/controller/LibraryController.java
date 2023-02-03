package cn.kdsa.user.controller;

import cn.kdsa.user.model.domain.Library;
import cn.kdsa.user.service.LibraryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/library")
@CrossOrigin()
public class LibraryController {

  @Resource
  private LibraryService libraryService;

  /**
   * 查询数据
   * @param title 书名
   * @return
   */
  @GetMapping("/get")
  public List<Library> get(String title){
    QueryWrapper<Library> queryWrapper = new QueryWrapper<>();
    if (StringUtils.isNotBlank(title)){
      // 根据 title 查询数据
      queryWrapper.like("title",title);
    }
    // 根据 id 降序排列
    queryWrapper.orderByDesc("id");
    List<Library> libraryList = libraryService.list(queryWrapper);
    return libraryList;
  }

  /**
   * 添加图书数据
   * @param library
   * @return
   */
  @PostMapping("/add")
  public boolean create(@RequestBody Library library){
    System.out.println(library);
    boolean result = libraryService.save(library);
    return result;
  }

  /**
   * 修改图书数据
   * @param library
   * @return
   */
  @PostMapping("/update")
  public boolean update(@RequestBody Library library){
    System.out.println(library);
    boolean result = libraryService.updateById(library);
    return result;
  }

  /**
   * 删除图书信息
   * @param library
   * @return
   */
  @PostMapping("/delete")
  public boolean delLibrary(@RequestBody Library library){
    System.out.println(library);
    Integer id = library.getId();
    boolean result = libraryService.removeById(id);
    return result;
  }
}
