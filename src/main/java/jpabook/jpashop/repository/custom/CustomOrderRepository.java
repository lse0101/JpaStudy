package jpabook.jpashop.repository.custom;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;

import java.util.List;

/**
 * Created by lse0101 on 2017-02-28.
 */
public interface CustomOrderRepository {
   public List<Order> search(OrderSearch orderSearch);
}
