package xyz.hzpc.manage.controller;

import org.springframework.web.bind.annotation.*;
import xyz.hzpc.manage.model.domain.User;
import xyz.hzpc.manage.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "this is a spring web!";
    }

    /**
     * 查询数据
     */
    @GetMapping("/get")
    public List<User> get(){
        List<User> userList = userService.list(null);
        return userList;
    }

    /**
     * 插入数据
     * @param user
     */
    @PostMapping("/")
    public String create(User user){
        boolean result = userService.save(user);
        return result ? "success" : "fail";
    }

    /**
     * 根据 id 修改数据
     * @param user
     */
    @PutMapping("/")
    public String update(User user){
        boolean result = userService.updateById(user);
        return result ? "success" : "fail";
    }

    /**
     * 根据 id 删除数据
     * @param request
     */
    @DeleteMapping("/")
    public String delete(HttpServletRequest request){
        String id = request.getParameter("id");
        boolean result = userService.removeById(id);
        return result ? "success" : "fail";
    }
}
