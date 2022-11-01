package cn.kdsa.user.contant;

/**
 * 用户常量表
 */
public interface UserContant {

  /**
   * 用户登入状态，键 key
   */
  String USER_LOGIN_STATE = "userLoginState";

  /**
   * 用户权限列表
   * 0 默认用户，1 管理员
   */
  int DEFAULT_ROLE = 0;

  int ADMIN_ROLE = 1;
}
