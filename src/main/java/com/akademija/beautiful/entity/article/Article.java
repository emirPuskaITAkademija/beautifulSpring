package com.akademija.beautiful.entity.article;

import com.akademija.beautiful.entity.order.Order;
import com.akademija.beautiful.entity.order.OrderItem;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Basic(optional = false)
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Basic(optional = false)
    @Column(name = "article_number")
    private String articleNumber;
    @Basic(optional = false)
    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @OneToMany(mappedBy = "article")
    private List<OrderItem> orderItems;


    public Article(){}

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return articleId != null ? articleId.equals(article.articleId) : article.articleId == null;
    }

    @Override
    public int hashCode() {
        return articleId != null ? articleId.hashCode() : 0;
    }
}
