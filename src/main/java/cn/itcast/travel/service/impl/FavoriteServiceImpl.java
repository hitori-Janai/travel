package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favDao = new FavoriteDaoImpl();
    @Override
    public boolean isFavorite(int uid, int rid) {
        Favorite f = favDao.findByRidAndUid(rid, uid);
        //查找到就为true
        return f != null;
    }

    @Override
    public void add(int rid, int uid) {
        favDao.addFavorite(rid, uid);

    }
}
