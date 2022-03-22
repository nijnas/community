package cn.hdu.community.service.Impl;

import cn.hdu.community.DAO.ArticleDAO;
import cn.hdu.community.entity.Article;
import cn.hdu.community.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDAO articledao;

    @Override
    public List<Article> findAllByArticleAuthorID(Integer articleAuthorID) {
        return articledao.findByArticleAuthorId(articleAuthorID);
    }

    @Override
    public List<Article> writeArticle(Article article, Integer articleAuthorID) {
        Article newArticle = new Article();
        newArticle.setArticleTitle(article.getArticleTitle());
        newArticle.setArticleAuthorId(articleAuthorID);
        newArticle.setArticleText(article.getArticleText());
        newArticle.setArticleStatus(article.getArticleStatus());
        newArticle.setArticleAllowComment(article.getArticleAllowComment());
        articledao.save(newArticle);
        return articledao.findTopById(newArticle.getId());
    }

    @Override
    public Article findArticleByArticleID(Integer articleID) {
        return articledao.findArticleById(articleID);
    }

    @Override
    public Boolean modifyArticle(Integer articleID, Article article) {
        Article originalArticle = findArticleByArticleID(articleID);
        originalArticle.setArticleTitle(article.getArticleTitle());
        articledao.save(originalArticle);
        return articledao.existsArticleById(originalArticle.getId());
    }

}
