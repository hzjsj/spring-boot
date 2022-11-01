package cn.kdsa.user.common;

public class ResultUtils {

  /**
   * 成功返回
   * @param data
   * @return
   * @param <T>
   */
  public static <T> BaseResponse<T> success(T data){

    return new BaseResponse<>(0,data,"ok","");
  }

  /**
   * 失败返回
   * @param errorCode
   * @return
   */
  public static BaseResponse error(ErrorCode errorCode){
    return new BaseResponse<>(errorCode);
  }
}
