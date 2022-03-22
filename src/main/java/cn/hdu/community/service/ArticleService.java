package cn.hdu.community.service;

import cn.hdu.community.entity.Article;

import java.util.List;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
public interface ArticleService {
    /**
     * 根据作者id即用户id返回该用户的所有文章
     *
     * @param articleAuthorID
     * @return
     */
    List<Article> findAllByArticleAuthorID(Integer articleAuthorID);

    /**
     * 写文章
     *
     * @param article
     * @param articleAuthorID
     * @return
     */
    Article writeArticle(Article article, Integer articleAuthorID);

    /**
     * 根据文章id查找文章
     *
     * @param articleID
     * @return
     */
    Article findArticleByArticleID(Integer articleID);

    /**
     * 根据文章id修改为文章
     *
     * @param articleID
     * @param article
     * @return
     */
    Boolean modifyArticle(Integer articleID, Article article);

    /**
     * 根据文章id删除文章
     *
     * @param articleID
     * @return
     */
    Boolean deleteArticleByID(Integer articleID);
}
