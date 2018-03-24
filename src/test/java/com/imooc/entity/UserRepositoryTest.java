package com.imooc.entity;

import com.imooc.repository.UserRepository;
import com.imooc.xunwuproject.ApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends ApplicationTests {

    @Autowired(required = false)
    private UserRepository userRepository;

    @Test
    public void testFindOne(){
        User user=userRepository.findOne(1L);
        Assert.assertEquals("wali",user.getName());
    }
}
