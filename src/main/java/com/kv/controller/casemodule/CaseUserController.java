package com.kv.controller.casemodule;

import com.kv.model.UserDomain;
import com.kv.result.DataResult;
import com.kv.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * ClassName: UserController <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * date: 2018年7月17日 下午4:04:33 <br/>
 *
 */
@Controller
@RequestMapping(value = "/caseUser")
@Api(value = "user")
public class CaseUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation(value = "添加用户", response = UserDomain.class)
    public @ResponseBody int addUser(UserDomain user) {
        return userService.addUser(user);
    }

    @GetMapping("/all")
    @ApiOperation(value = "分页查询所有用户", response = UserDomain.class)
    public @ResponseBody
    DataResult<UserDomain> findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        DataResult<UserDomain> userDomains = userService.findAllUser(pageNum, pageSize);
        System.err.println("----------------test**** hotcode2------------------------");
        return userDomains;
    }

    @PostMapping("/testHotCode2")
    @ApiOperation(value = "测试HotCode2", response = UserDomain.class)
    public @ResponseBody DataResult<UserDomain> testHotCode2(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                             @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        DataResult<UserDomain> userDomains = userService.findAllUser(pageNum, pageSize);
        System.err.println("----------------test hotcode2------------------------");
        return userDomains;
    }

    @GetMapping("/mybatis")
    @ApiOperation(value = "测试mybatis批量插入", response = UserDomain.class)
    public @ResponseBody Object mybatisBatchInsertTest() {
        userService.insertMybatisBatch();
        return null;
    }

}
