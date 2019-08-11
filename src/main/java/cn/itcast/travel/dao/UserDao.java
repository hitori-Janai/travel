package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    public User findByUserName(String username);

    public User findByUsernamePassword(String username, String password);

    public void save(User user);

    public void update(User user);

    /**
     * 查找用户根据唯一激活码
     * @param code
     * @return
     */
   public User findByCode(String code);

//   public User findByKeyValue();
}
