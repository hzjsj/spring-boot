package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kdsa.user.model.domain.Types;
import generator.service.TypesService;
import generator.mapper.TypesMapper;
import org.springframework.stereotype.Service;

/**
* @author xiulong
* @description 针对表【types(豆瓣 type250)】的数据库操作Service实现
* @createDate 2023-02-01 17:16:11
*/
@Service
public class TypesServiceImpl extends ServiceImpl<TypesMapper, Types>
    implements TypesService{

}




