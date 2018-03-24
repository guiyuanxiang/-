package com.imooc.xunwuproject;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ActiveProfiles("test") 根据test文件进行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
@ActiveProfiles("test")
public class ApplicationTests {


}
