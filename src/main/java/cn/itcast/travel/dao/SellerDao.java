package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Seller;

public interface SellerDao {

    /**
     * 查找卖家 tab_seller
     * @param sid
     * @return
     */
   public Seller findSeller(int sid);
}
