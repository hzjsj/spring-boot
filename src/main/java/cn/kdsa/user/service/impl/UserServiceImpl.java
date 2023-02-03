package cn.kdsa.user.service.impl;

import cn.kdsa.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kdsa.user.model.domain.User;
import cn.kdsa.user.mapper.UserMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.*;
import java.util.stream.Collectors;

import static cn.kdsa.user.contant.UserContant.*;

/**
* @author xiulong
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2022-10-30 16:37:32
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

  @Resource
  private UserMapper userMapper;

  /**
   * 用户登入信息处理
   * @param username
   * @param password
   * @param request
   * @return
   */
  @Override
  public User userLogin(String username, String password, HttpServletRequest request) {

    // 1. 判断用户名和密码是否为空值
    if (StringUtils.isAllBlank(username,password)){
      return null;
    }

    // 2. md5 单向非对称加密
    String newPassword = md5Digest(password);

    // 3. 根据账号密码，去查询数据库
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("userAccount",username);
    queryWrapper.eq("userPassword",newPassword);
    User user = userMapper.selectOne(queryWrapper);

    // 4. 用户信息去除敏感信息
    User safetyUser = getSafetyUser(user);

    // 4. 记录用户的登入状态
    request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);

    return safetyUser;
  }

  /**
   * 去除用户敏感信息
   * @param originUser 用户信息
   * @return 返回脱敏后用户信息
   */
  @Override
  public User getSafetyUser(User originUser){
    if (originUser==null){
      return null;
    }
    User safetyUser = new User();
    safetyUser.setId(originUser.getId());
    safetyUser.setUsername(originUser.getUsername());
    safetyUser.setUserAccount(originUser.getUserAccount());
    safetyUser.setAvatarUrl(originUser.getAvatarUrl());
    safetyUser.setGender(originUser.getGender());
    safetyUser.setPhone(originUser.getPhone());
    safetyUser.setEmail(originUser.getEmail());
    safetyUser.setTags(originUser.getTags());
    safetyUser.setUserRole(originUser.getUserRole());
    safetyUser.setCreateTime(originUser.getCreateTime());
    return safetyUser;
  }

    @Override
    public int userLogout(HttpServletRequest request) {

      /**
       * 移除登录态
       */
      request.getSession().removeAttribute(USER_LOGIN_STATE);
      return 200;
    }

  /**
   * Spring 自带加密类，md5 单向非对称加密
   */
  String md5Digest(String password){
    String newPassword = DigestUtils.md5DigestAsHex((SALT+ password).getBytes());
    return newPassword;
  }

  /**
   * 添加用户
   * @param username      用户昵称
   * @param userAccount   用户账号
   * @param userPassword  用户密码
   * @return  影响行数
   */
  @Override
  public int addUser(String username, String userAccount, String userPassword) {
    String newPassword = md5Digest(userPassword);
    User user = new User();
    user.setUsername(username);
    user.setUserAccount(userAccount);
    user.setUserPassword(newPassword);
    int result = userMapper.insert(user);
    return result;
  }

  @Override
  public int updateUser(Long id,String username, String userAccount, String userPassword) {
    if (StringUtils.isAllBlank(userPassword)){
      return 1;
    }

    String newPassword = md5Digest(userPassword);
    User user = new User();
    user.setId(id);
    user.setUsername(username);
    user.setUserAccount(userAccount);
    user.setUserPassword(newPassword);
    int result = userMapper.updateById(user);
    return result;
  }

  /**
   * 根据标签搜索用户
   * @param tagNameList
   * @return
   */
  @Override
  public List<User> searchUsersByTages(List<String> tagNameList) {
    if (CollectionUtils.isEmpty(tagNameList)) {
      return null;
    }

    System.out.println("^^^……………………………………………………………………………………1234567");

    // 1.  查询所有用户
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    List<User> userList = userMapper.selectList(queryWrapper);
    Gson gson = new Gson();

    // 2. 在内存中判断是否包含要求的标签
    return userList.stream().filter(user -> {
      String tagsStr = user.getTags();
      Set<String > tempTagNameSet = gson.fromJson(tagsStr, new TypeToken<Set<String>>() {
      }.getType());
      tempTagNameSet = Optional.ofNullable(tempTagNameSet).orElse(new HashSet<>());
      for (String tagName:tagNameList){
        if (!tempTagNameSet.contains(tagName)){
          return false;
        }
      }
      return true;
    }).map(this::getSafetyUser).collect(Collectors.toList());

  }




  @Deprecated
  public List<User> searchUsersByTage(List<String> tagNameList) {
    if (CollectionUtils.isEmpty(tagNameList)){
      return null;
    }

    /**
     * 通过 sql 语句查询
     */
    if (1==0){
      long currentTimeMillis = System.currentTimeMillis();
      QueryWrapper<User> queryWrapper = new QueryWrapper<>();
      for(String tagName : tagNameList){
        queryWrapper = queryWrapper.like("tags",tagName);
      }
      List<User> userList = userMapper.selectList(queryWrapper);
      System.out.println("查询时间 sql 语句"+ (System.currentTimeMillis()-currentTimeMillis));
      return userList.stream().map(this::getSafetyUser).collect(Collectors.toList());
    }

    /**
     * 通过内存方式查询
     */
    if (1==1){
      Gson gson = new Gson();
      List<User> users = userMapper.selectList(null);
      users.stream().filter(user->{
        String tagsStr = user.getTags();
        if(StringUtils.isBlank(tagsStr)){
          return false;
        }
        System.out.println("--------------------------");
        System.out.println(user);
        Set<String> fromJson = gson.fromJson(tagsStr, new TypeToken<Set<User>>() {
        }.getType());
        for (String tagName:tagNameList){
          if (!fromJson.contains(tagName)){
            return false;
          }
        }
        return true;
      });
      return users;
    }

    return null;
  }

  @Override
  public Map<String, Object> selectMapById(Long id) {
    return null;
  }


  /**
   *
   * @param name 名称
   */
  @Override
  public void getByName(String name){
      System.out.println("Server"+name);
  }
}




