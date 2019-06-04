package com.baizhi.cmfz;


import com.baizhi.CmfzApplication;
import com.baizhi.entity.User;
import com.baizhi.mapper.ArticleMapper;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.mapper.UserMapper;
import com.baizhi.service.ArticleService;
import com.baizhi.service.BannerService;


import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Map;
import java.util.Set;

@SpringBootTest(classes=CmfzApplication.class)
//在工厂环境下启动测试
@RunWith(SpringRunner.class)
public class CmfzApplicationTests {
    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    BannerService bannerService;
    @Autowired
    UserService userService;
   @Autowired
    private ArticleService articleService;
   @Autowired
   private ArticleMapper articleMapper;
    @Test
    public void Test1() {
        Map<String, Object> map = bannerService.selectAllBanner(1, 1);
        Set keys=map.keySet();
        for (Object key : keys) {
            System.out.print(key);
            System.out.println(map.get(key));
        }
    }
    @Test
    public void Test2(){
        Integer  count = bannerMapper.selectCount();
        System.out.println(count);
    }
    @Test
    public void Test3(){
        User user1 = userMapper.queryOneUser("test");
        System.out.println(user1.toString());
        userService.queryOneUser("test","12345");
    }
    @Test
    public void Test4(){
        Integer count = articleMapper.selectCount();
        System.out.println(count);
         Map<String, Object> map = articleService.selectAllArticle(1, 1);
       System.out.println(map);
    }

}



