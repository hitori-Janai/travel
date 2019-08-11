package cn.itcast.travel.service;

public interface FavoriteService {
    /**
     *
     * @param uid
     * @param rid
     * @return
     */
    boolean isFavorite(int uid, int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void add(int rid, int uid);
}
