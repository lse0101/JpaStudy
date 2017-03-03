package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lse0101 on 2017-02-27.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
}
