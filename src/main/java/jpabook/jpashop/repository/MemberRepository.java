package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lse0101 on 2017-02-27.
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
}
