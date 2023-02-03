package cn.kdsa.user.model.domain.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAddRequest implements Serializable {

  /**
   * 用户昵称
   */
  private String username;

  /**
   * 用户账号
   */
  private String userAccount;

  /**
   * 用户密码
   */
  private String userPassword;
}
