package jpabook.multiplyAssocicate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Product> product;
	public static volatile SingularAttribute<Order, Integer> orderAmount;
	public static volatile SingularAttribute<Order, Member> member;
	public static volatile SingularAttribute<Order, Long> id;

}

