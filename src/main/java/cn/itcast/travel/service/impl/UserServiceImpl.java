package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户,成功返回true
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        /*
         * 查找用户是否存在
         * 不存在创建用户
         * */
        User u = userDao.findByUserName(user.getUsername());
        if (u != null)
            return false;
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        userDao.save(user);
//sakkura618@gmail.com
        String content = "<a herf='http://localhost/travel/activeUserServlet?code=" + user.getCode() + "'>点击激活</a>";
        MailUtils.sendMail(user.getEmail(), content, "注册验证激活 XX旅游网");
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if (user == null) return false;
        user.setStatus("Y");
        userDao.update(user);
        return true;
    }

    @Override
    public User login(String username, String password) {
        User u = userDao.findByUsernamePassword(username, password);
        return u;
    }
}
