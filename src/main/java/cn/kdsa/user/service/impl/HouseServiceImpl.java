package cn.kdsa.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kdsa.user.model.domain.House;
import cn.kdsa.user.service.HouseService;
import cn.kdsa.user.mapper.HouseMapper;
import org.springframework.stereotype.Service;

/**
* @author xiulong
* @description 针对表【house(房源信息)】的数据库操作Service实现
* @createDate 2023-01-22 23:34:49
*/
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House>
    implements HouseService{

}




