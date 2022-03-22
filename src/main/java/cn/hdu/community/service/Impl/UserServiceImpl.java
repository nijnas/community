package cn.hdu.community.service.Impl;

import cn.hdu.community.DAO.UserDAO;
import cn.hdu.community.entity.User;
import cn.hdu.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userdao;

    @Override
    public Boolean existsUserByUserEmail(String userEmail) {
        return userdao.existsUserByUserEmail(userEmail);
    }

    @Override
    public Boolean userRegistered(String userEmail, String userPassword) {
        User user = new User();
        user.setUserEmail(userEmail);
        user.setUserPassword(userPassword);
        userdao.save(user);
        return existsUserByUserEmail(userEmail);
    }

    @Override
    public User findAllByUserEmail(String userEmail) {
        return userdao.findAllByUserEmail(userEmail);
    }

    @Override
    public void deleteUserByUserID(int userID) {
        userdao.deleteAllById(userID);
    }
}
