package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.*;
import cn.itcast.travel.dao.impl.*;
import cn.itcast.travel.domain.*;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao rd = new RouteDaoImpl();
    private RouteImgDao ridao = new RouteImgDaoImpl();
    private SellerDao sd = new SellerDaoImpl();
    private CategoryDao cd = new CategoryDaoImpl();
    private FavoriteDao favDao = new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize,String rname) {
        PageBean<Route> pb = new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);
        pb.setTotalCount(rd.queryTotal(cid,rname));
        //设置总页数
//        pageSize = pageSize <= 0 ? 5 : pageSize;
        pb.setTotalPage((pb.getTotalCount() + pageSize - 1) / pageSize);

        int start = (currentPage - 1) * pageSize;
        pb.setList(rd.queryRoute(cid, start, pageSize,rname));
        return pb;
    }

    @Override
    public Route findOne(int rid) {
        Route route = rd.findOne(rid);
        List<RouteImg> lri = ridao.findImgs(rid);
        Seller seller = sd.findSeller(route.getSid());
        Category category = cd.findOne(route.getCid());
        int count = favDao.findCountByRid(route.getRid());

        route.setCount(count);
        route.setCategory(category);
        route.setRouteImgList(lri);
        route.setSeller(seller);
        return route;
    }
}
