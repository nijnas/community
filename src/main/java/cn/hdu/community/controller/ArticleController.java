package cn.hdu.community.controller;

import cn.hdu.community.dto.Result;
import cn.hdu.community.entity.Article;
import cn.hdu.community.entity.User;
import cn.hdu.community.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author zhangxin
 * @Date 2022/3/13
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleservice;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/article/findAllArticle")
    public Result getAllArticle() {
        HttpSession mySession = httpServletRequest.getSession(false);
        User user = (User) mySession.getAttribute("user");
        Integer authorID = user.getId();
        List<Article> article = articleservice.findAllByArticleAuthorID(authorID);
        return Result.success("获取成功", article);
    }

    @RequestMapping("/article/writeArticle")
    public Result saveArticle(@RequestBody Article article) {
        HttpSession mySession = httpServletRequest.getSession(false);
        User user = (User) mySession.getAttribute("user");
        Integer authorID = user.getId();
        List<Article> newArticle = articleservice.writeArticle(article, authorID);
        if (newArticle != null) {
            return Result.success("写入成功", newArticle);
        } else {
            return Result.error("写入失败", "");
        }
    }

    @RequestMapping("/article/modify/{articleId}")
    public Result modifyArticle(@PathVariable(name = "articleId") Integer articleID, @RequestBody Article article) {
        articleservice.modifyArticle(articleID, article);
        return Result.success("修改成功", "");
    }

    @RequestMapping("/article/details/{articleID}")
    public Result getArticle(@PathVariable(name = "articleID") Integer articleID) {
        Article article = articleservice.findArticleByArticleID(articleID);
        return Result.success("获取成功", article);
    }
}
