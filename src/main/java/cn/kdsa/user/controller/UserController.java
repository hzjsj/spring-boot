package cn.kdsa.user.controller;

import cn.kdsa.user.common.BaseResponse;
import cn.kdsa.user.common.ErrorCode;
import cn.kdsa.user.common.ResultUtils;
import cn.kdsa.user.model.domain.User;
import cn.kdsa.user.model.domain.request.UserLoginRequest;
import cn.kdsa.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static cn.kdsa.user.contant.UserContant.*;

@RestController
@RequestMapping("/api")
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping("")
  public String index(){
    return "this is a spring web...";
  }

//  @PostMapping("/login/account")
//  public User userLogin(HttpServletRequest request){
//
//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//    return userService.userLogin(username,password,request);
//  }

  @GetMapping("/currentUser")
  public BaseResponse<User> getCurrentUser(HttpServletRequest request){
    Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
    User currentUser = (User) userObj;
    if (currentUser == null){
      return ResultUtils.error(ErrorCode.NOT_LOGIN);
    }

    Long userId = currentUser.getId();
    User user = userService.getById(userId);
    User result = userService.getSafetyUser(user);
    return ResultUtils.success(result);
  }

  @PostMapping("/login/account")
  public BaseResponse<String> userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){

    if (userLoginRequest == null){
      return null;
    }
    String username = userLoginRequest.getUsername();
    String password = userLoginRequest.getPassword();

    User user = userService.userLogin(username, password, request);

    if (user==null){
      return ResultUtils.error(ErrorCode.LOGIN_FAIL);
    }
    String currentAuthority = user.getUserRole()==1 ?"admin":"user";

    return ResultUtils.success(currentAuthority);
  }

  @RequestMapping("/login/logout")
  public BaseResponse<Integer> userLogout(HttpServletRequest request) {
    if (request == null) {
    }
    int result = userService.userLogout(request);
    return ResultUtils.success(result);
  }

  /**
   * 简单鉴权，判断是否为管理员
   * @param request 请求头信息
   * @return 逻辑值
   */
  private boolean isAdmin(HttpServletRequest request){
    Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);

    User user = (User)userObj;

    if (user ==null && ADMIN_ROLE==1){
      return false;
    }
    return true;

  };

  @GetMapping("/search")
  public BaseResponse<List<User>> searchUsers(String name, HttpServletRequest request){

    if (!isAdmin(request)){
      return ResultUtils.error(ErrorCode.NOT_LOGIN);
    }


    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    if (StringUtils.isNotBlank(name)){
      queryWrapper.like("name",name);
    }
    List<User> userList = userService.list(queryWrapper);

    List<User> resultList = userList.stream().map(item -> userService.getSafetyUser(item)).collect(Collectors.toList());

    return ResultUtils.success(resultList);


  }



  @GetMapping("/hello")
  public BaseResponse<String> hello() {

    //return new BaseResponse<>(0,"this is a hello world!","message");
    //return ResultUtils.success("lll");
    return ResultUtils.success("哈哈哈哈哈");
  }

  @GetMapping("/error")
  public BaseResponse<String> error() {

    return ResultUtils.error(ErrorCode.PARAMS_ERROR);
  }
}
