package cn.hdu.community.DAO;

import cn.hdu.community.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
public interface ArticleDAO extends JpaRepository<Article, Integer> {
    List<Article> findByArticleAuthorId(Integer articleAuthorID);

    Boolean existsArticleById(Integer articleID);

    Article findArticleById(Integer articleID);

    List<Article> findTopById(Integer articleID);
}
