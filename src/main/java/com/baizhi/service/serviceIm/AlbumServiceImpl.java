package com.baizhi.service.serviceIm;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS , readOnly = true)
    public Map<String,Object> selectByPrimaryKey(Integer page, Integer rows) {
        //开始下标
        Integer start=(page-1)*rows;
        //jqgrid  map   page当前的页数  total总页数    records总条数  rows查询到的数据
        List<Album> albums = albumMapper.selectByPrimaryKey(start, rows);
        Integer records=albumMapper.selectCount();
        Integer total= (records%rows==0)?(records/rows):(records/rows+1); //total
        HashMap hashMap = new HashMap();
        hashMap.put("total",total);
        hashMap.put("rows",albums);
        hashMap.put("records",records);
        hashMap.put("page",page);
        return hashMap;
    }


}
