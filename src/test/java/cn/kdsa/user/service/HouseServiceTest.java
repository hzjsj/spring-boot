package cn.kdsa.user.service;
import java.util.Date;
import java.util.List;

import cn.kdsa.user.model.domain.House;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HouseServiceTest {

  @Resource
  private  HouseService houseService;



  @Test
  void testAddHouse(){
    House house = new House();
    boolean save = houseService.save(house);
    System.out.println(save);

  }

  @Test
  void testGetHouse(){
    List<House> list = houseService.list();
    System.out.println(list);
  }
}
