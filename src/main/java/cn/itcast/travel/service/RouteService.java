package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {

    /**
     * 查找一页数据
     * @param cid
     * @param currentPage > 0
     * @param pageSize > 0
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname);

    /**
     * 根据rid查找route对象
     * @param rid
     * @return
     */
    Route findOne(int rid);
}
