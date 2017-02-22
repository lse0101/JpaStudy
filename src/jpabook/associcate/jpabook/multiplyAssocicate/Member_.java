package jpabook.multiplyAssocicate;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ {

	public static volatile ListAttribute<Member, Order> orders;
	public static volatile SingularAttribute<Member, String> id;
	public static volatile SingularAttribute<Member, String> username;

}

