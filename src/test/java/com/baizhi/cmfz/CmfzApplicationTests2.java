package com.baizhi.cmfz;
import com.baizhi.CmfzApplication;
import com.baizhi.entity.User;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.AlbumService;
import com.baizhi.service.ChapterService;
import com.baizhi.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CmfzApplication.class)
@RunWith(SpringRunner.class)
public class CmfzApplicationTests2 {
    @Autowired
    private UserService userService;
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ChapterMapper chapterMapper;
    @Test
    public void Test1() {
        Map<String, Object> map = userService.queryAllUser(1, 1);
        System.out.println(map);
    }

    @Test
    public void Test2() {
        List<User> list = userService.getAll();
        System.out.println(list);
    }
    @Test
    public void Test3() {
       // List<Album> albums = albumMapper.selectByPrimaryKey(1, 1);
        Map<String, Object> map = albumService.selectByPrimaryKey(1, 1);
        System.out.println(map);
    }
    @Test //测试专辑的章节
    public void Test4(){
        Map<String, Object> map = chapterService.selectAllChapter("1", 1, 1);
        System.out.println(map);
    }

}



