package cn.kdsa.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.kdsa.user.model.domain.Library;
import cn.kdsa.user.service.LibraryService;
import cn.kdsa.user.mapper.LibraryMapper;
import org.springframework.stereotype.Service;

/**
* @author xiulong
* @description 针对表【library】的数据库操作Service实现
* @createDate 2022-12-12 11:22:27
*/
@Service
public class LibraryServiceImpl extends ServiceImpl<LibraryMapper, Library>
    implements LibraryService{

}




