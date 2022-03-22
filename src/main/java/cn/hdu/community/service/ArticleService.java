package cn.hdu.community.service;

import cn.hdu.community.entity.Article;

import java.util.List;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
public interface ArticleService {
    List<Article> findAllByArticleAuthorID(Integer articleAuthorID);

    List<Article> writeArticle(Article article, Integer articleAuthorID);

    Article findArticleByArticleID(Integer articleID);

    Boolean modifyArticle(Integer articleID, Article article);
}
