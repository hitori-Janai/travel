package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

public interface UserService {
    public boolean register(User user);

    /**
     * 激活激活码
     * @param code 激活码
     * @return 是否成功
     */
    boolean active(String code);

    User login(String username, String password);

}
