package cn.hdu.community.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "article", indexes = {
        @Index(name = "author_id_idx", columnList = "article_author_id")
})

@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id", nullable = false)
    private Integer id;

    @Column(name = "article_title", length = 45)
    private String articleTitle;

    @Column(name = "article_slug", length = 45)
    private String articleSlug;

    @Column(name = "article_created")
    @CreatedDate
    private Date articleCreated;

    @Column(name = "article_modified")
    @LastModifiedDate
    private Date articleModified;

    @Lob
    @Column(name = "article_text")
    private String articleText;

    @Column(name = "article_author_id")
    private Integer articleAuthorId;

    @Column(name = "article_type", length = 45)
    private String articleType;

    @Lob
    @Column(name = "article_status")
    private String articleStatus;

    @Column(name = "article_allow_comment", length = 2)
    private String articleAllowComment;

    @Column(name = "article_comments_num")
    private Integer articleCommentsNum;

    public Integer getArticleCommentsNum() {
        return articleCommentsNum;
    }

    public void setArticleCommentsNum(Integer articleCommentsNum) {
        this.articleCommentsNum = articleCommentsNum;
    }

    public String getArticleAllowComment() {
        return articleAllowComment;
    }

    public void setArticleAllowComment(String articleAllowComment) {
        this.articleAllowComment = articleAllowComment;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Integer getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(Integer articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    public Date getArticleModified() {
        return articleModified;
    }

    public void setArticleModified(Date articleModified) {
        this.articleModified = articleModified;
    }

    public Date getArticleCreated() {
        return articleCreated;
    }

    public void setArticleCreated(Date articleCreated) {
        this.articleCreated = articleCreated;
    }

    public String getArticleSlug() {
        return articleSlug;
    }

    public void setArticleSlug(String articleSlug) {
        this.articleSlug = articleSlug;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}