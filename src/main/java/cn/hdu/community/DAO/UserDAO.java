package cn.hdu.community.DAO;

import cn.hdu.community.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
public interface UserDAO extends JpaRepository<User, Integer> {
    /**
     * 根据用户邮箱判断是否存在该用户
     *
     * @param userEmail
     * @return
     */
    Boolean existsUserByUserEmail(String userEmail);

    /**
     * 根据邮箱获取该用户所有信息
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
    @Modifying
    @Transactional
    void deleteAllById(int userID);

    @Query(nativeQuery = true,value = "select 1 from user where user_id=?1")
    User findUser(int id);
}
