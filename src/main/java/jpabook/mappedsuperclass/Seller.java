package jpabook.mappedsuperclass;

import javax.persistence.Entity;

/**
 * Created by lse0101 on 2017-02-15.
 */
@Entity
public class Seller extends BaseEntity{
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
