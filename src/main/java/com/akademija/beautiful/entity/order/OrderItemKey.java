package com.akademija.beautiful.entity.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderItemKey implements Serializable {

    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "article_id")
    private Long articleId;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemKey that = (OrderItemKey) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        return articleId != null ? articleId.equals(that.articleId) : that.articleId == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (articleId != null ? articleId.hashCode() : 0);
        return result;
    }
}
