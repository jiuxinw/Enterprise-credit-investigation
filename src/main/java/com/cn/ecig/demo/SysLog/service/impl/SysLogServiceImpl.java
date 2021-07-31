package com.cn.ecig.demo.SysLog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.ecig.demo.SysLog.entity.SysLog;
import com.cn.ecig.demo.SysLog.mapper.SysLogMapper;
import com.cn.ecig.demo.SysLog.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liguang
 * @since 2021-07-22
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }

    @Override
    public List<String> getParmsList(String name) {
        List<String > list=new ArrayList<>();
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("username",name);
     List<SysLog> sysLogs =sysLogMapper.selectList(wrapper);
        for (SysLog s:sysLogs
             ) {
            if(s.getParams().length()==10) {
                list.add(s.getParams().substring(1,7));
            }
        }
        System.out.println(list);
        return list;


    }

    @Override
    public Map<String, Integer> getHot() {
      Map<String,Integer>map=new HashMap<>();
      QueryWrapper wrapper=new QueryWrapper();
//      wrapper.groupBy("params");
      List<SysLog> sysLogs=sysLogMapper.selectList(wrapper);
        for (SysLog s : sysLogs) {
            if (s.getParams().length()==10){
                String c=s.getParams().substring(2,8);
                QueryWrapper qwrapper=new QueryWrapper();
                qwrapper.eq("params",s.getParams());
                map.put(c,sysLogMapper.selectCount(qwrapper));
            }
        }
        return sortMapByValues(map);
    }

    @Override
    public int getCount(String code) {
        QueryWrapper wrapper=new QueryWrapper();
        String sc="["+"\""+code+"\""+"]";
        wrapper.eq("params",sc);
        int res=sysLogMapper.selectCount(wrapper);
        return res;
    }

    public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> aMap) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        aMap.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }

}
