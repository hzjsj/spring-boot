package cn.kdsa.user.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 房源信息
 * @TableName house
 */
@TableName(value ="house")
@Data
public class House implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 小区名称
     */
    private String residentialQuarters;

    /**
     * 户型，居室
     */
    private Integer room;

    /**
     * 户型，大厅
     */
    private Integer hall;

    /**
     * 户型，卫生间
     */
    private Integer restRoom;

    /**
     * 户型，厨房
     */
    private Integer kitchen;

    /**
     * 户型，阳台
     */
    private Integer balcony;

    /**
     * 面积
     */
    private Double area;

    /**
     * 租赁类型：0 是合租，1是整租
     */
    private Integer rentalType;

    /**
     * 朝向
     */
    private String orientation;

    /**
     * 维护
     */
    private String maintain;

    /**
     * 入住
     */
    private String moveInto;

    /**
     * 房屋楼层
     */
    private Integer storey;

    /**
     * 楼层总数
     */
    private Integer storeyTotal;

    /**
     * 电梯
     */
    private String elevator;

    /**
     * 车位
     */
    private String parkingPlace;

    /**
     * 用水
     */
    private String useWater;

    /**
     * 用电
     */
    private String useElectricity;

    /**
     * 配套设施
     */
    private String supportingFacilities;

    /**
     * 房子图片
     */
    private String housePicture;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
