package cn.kdsa.user.controller;

import cn.kdsa.user.common.BaseResponse;
import cn.kdsa.user.common.ErrorCode;
import cn.kdsa.user.common.ResultUtils;
import cn.kdsa.user.model.domain.User;
import cn.kdsa.user.model.domain.request.UserAddRequest;
import cn.kdsa.user.model.domain.request.UserLoginRequest;
import cn.kdsa.user.model.domain.request.UserUpdateRequest;
import cn.kdsa.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static cn.kdsa.user.contant.UserContant.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000"})
@Validated
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping("")
  public String index(){
    return "this is a spring web...";
  }

  @RequestMapping("/book")
  public String boos(){
    return "this is a boos web...";
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

  @PostMapping("/user/add")
  public BaseResponse<Integer> addUser(@RequestBody UserAddRequest UserAddRequest, HttpServletRequest request) {
    if (UserAddRequest == null) {
      return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }
    String username = UserAddRequest.getUsername();
    String userAccount = UserAddRequest.getUserAccount();
    String userPassword = UserAddRequest.getUserPassword();
    int result = userService.addUser(username, userAccount, userPassword);
    return ResultUtils.success(result);
  }

  @PostMapping("/user/update")
  public BaseResponse<Integer> updateUser(@RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request) {
    if (userUpdateRequest == null) {
      return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }
    Long id = userUpdateRequest.getId();
    String username = userUpdateRequest.getUsername();
    String userAccount = userUpdateRequest.getUserAccount();
    String userPassword = userUpdateRequest.getUserPassword();
    int result = userService.updateUser(id,username, userAccount, userPassword);
    return ResultUtils.success(result);
  }


  @PostMapping("/user/addss")
  public BaseResponse<Boolean> addUserss(@RequestBody UserUpdateRequest userUpdateRequest, HttpServletRequest request) {
    if (userUpdateRequest == null) {
      return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }
    User user = new User();
    user.setId(userUpdateRequest.getId());
    user.setUsername(userUpdateRequest.getUsername());
    user.setUserAccount(userUpdateRequest.getUserAccount());
    user.setUserPassword(userUpdateRequest.getUserPassword());

    boolean result = userService.save(user);

    //long newUserId = user.getId();
    return ResultUtils.success(result);
  }

 public String delete(HttpServletRequest request){
   String id = request.getParameter("id");
   return "success";
 }

  @GetMapping("/hello")
  public BaseResponse<List<User>> hello() {

    List<User> userList = userService.list(null);


    return ResultUtils.success(userList);
  }

  @GetMapping("/error")
  public BaseResponse<String> error() {

    return ResultUtils.error(ErrorCode.PARAMS_ERROR);
  }

  @GetMapping("/name/{name}")
  public void getByName(@PathVariable String name){
    userService.getByName(name);
  }
}
