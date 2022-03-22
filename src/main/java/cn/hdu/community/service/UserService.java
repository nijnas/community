package cn.hdu.community.service;

import cn.hdu.community.entity.User;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
public interface UserService {
    /**
     * 根据用户邮箱判断该用户是否存在
     *
     * @param userEmail
     * @return
     */
    Boolean existsUserByUserEmail(String userEmail);

    /**
     * 用户注册
     *
     * @param userEmail
     * @param userPassword
     * @return
     */
    Boolean userRegistered(String userEmail, String userPassword);

    /**
     * 根据用户邮箱查找该用户所有信息
     *
     * @param userEmail
     * @return
     */
    User findAllByUserEmail(String userEmail);

    /**
     * 根据用户id删除用户
     *
     * @param userID
     */
    void deleteUserByUserID(int userID);
}
