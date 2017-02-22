package jpabook.shop.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Delivery.class)
public abstract class Delivery_ {

	public static volatile SingularAttribute<Delivery, String> zipcode;
	public static volatile SingularAttribute<Delivery, String> city;
	public static volatile SingularAttribute<Delivery, String> street;
	public static volatile SingularAttribute<Delivery, Long> id;
	public static volatile SingularAttribute<Delivery, Order> order;
	public static volatile SingularAttribute<Delivery, DeliveryStatus> status;

}

