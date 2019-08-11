package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    /**
     * 根据cid查找数据条数
     * @param cid
     * @return
     */
    public int queryTotal(int cid,String rname);

    /**
     * 查找Route数据
     *
     * @param cid
     * @param start 偏移量
     * @param pageSize 单页容量
     * @return
     */
    public List<Route> queryRoute(int cid, int start, int pageSize,String rname);

    /**
     * 在tab_route 查找route
     * @param rid
     * @return
     */
    public Route findOne(int rid);
}


