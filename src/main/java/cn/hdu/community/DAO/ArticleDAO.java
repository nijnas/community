package cn.hdu.community.DAO;

import cn.hdu.community.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
public interface ArticleDAO extends JpaRepository<Article, Integer> {
    /**
     * 根据作者id即用户id获取属于该用户的全部文章
     *
     * @param articleAuthorID
     * @return
     */
    List<Article> findByArticleAuthorId(Integer articleAuthorID);

    /**
     * 根据文章id判断该文章是否存在
     *
     * @param articleID
     * @return
     */
    Boolean existsArticleById(Integer articleID);

    /**
     * 根据文章id查找该文章
     *
     * @param articleID
     * @return
     */
    Article findArticleById(Integer articleID);

    /**
     * 根据文章id删除文章
     *
     * @param articleID
     */
    @Transactional
    void deleteArticleById(Integer articleID);
}
