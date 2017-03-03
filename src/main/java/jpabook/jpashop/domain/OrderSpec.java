package jpabook.jpashop.domain;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

/**
 * Created by lse0101 on 2017-02-28.
 */
public class OrderSpec {

    public static Specification<Order> memberNameLike(final String memberName) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> o, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if(StringUtils.isEmpty(memberName)) return null;

                Join<Order, Member> m = o.join("member", JoinType.INNER);

                return cb.like(m.<String>get("name"), "%"+memberName+"%");
            }
        };
    }

    public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
        return new Specification<Order>() {
            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if(orderStatus == null) return null;

                return cb.equal(root.get("status"), orderStatus);
            }
        };
    }
}
