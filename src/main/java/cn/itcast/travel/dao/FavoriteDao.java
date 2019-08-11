package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    public void addFavorite(int rid, int uid);
}
