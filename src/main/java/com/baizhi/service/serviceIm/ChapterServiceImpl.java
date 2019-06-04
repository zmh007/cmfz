package com.baizhi.service.serviceIm;


import com.baizhi.entity.Chapter;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS , readOnly = true)
    public Map<String,Object> selectAllChapter(String albumId,Integer page, Integer rows) {
        //开始下标
       Integer start=(page-1)*rows;
        //jqgrid  map   page当前的页数  total总页数    records总条数  rows查询到的数据
        List<Chapter> chapters = chapterMapper.selectAllChapter(albumId,start , rows);
        Integer records=chapterMapper.selectCount(albumId);
        Integer total= (records%rows==0)?(records/rows):(records/rows+1); //total
        HashMap hashMap = new HashMap();
        hashMap.put("total",total);
        hashMap.put("rows",chapters);
        hashMap.put("records",records);
        hashMap.put("page",page);
        return hashMap;
    }


}
