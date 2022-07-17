package com.cms;

import com.cms.mapper.MenuMapper;
import com.cms.pojo.User;
import com.cms.service.Impl.AuthorizeServiceImpl;
import com.cms.service.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class CmsApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    private UserServiceImpl userService;
    @Test
    void testMybatisPlus(){
        User user = userService.findByUid(1);
        System.out.println(user);
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void TestBCryptPasswordEncoder(){

//        $2a$10$Q4hhqL6ZRbKNuyihXaPzo.lEa9PKJyOWu0z4u45CEJtwlSkcjAHNe


        System.out.println(passwordEncoder.
                matches("123456",
                        "$2a$10$iIxgKQuilRYhhbhT8088yeY0eCpCbuCVFV6d2bZ3iI/EPB5BE.SPG"));
        String encode = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        System.out.println(encode);
        System.out.println(encode2);

    }

    @Resource
    private MenuMapper menuMapper;
    @Test
    void testAuthorizeService(){
        System.out.println(menuMapper.selectPermsByUserUid(1));
    }
}
