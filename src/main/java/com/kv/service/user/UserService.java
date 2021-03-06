package com.kv.service.user;

import com.kv.model.UserDomain;
import com.kv.result.DataResult;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(UserDomain user);

    DataResult<UserDomain> findAllUser(int pageNum, int pageSize);

    void insertMybatisBatch();
}
