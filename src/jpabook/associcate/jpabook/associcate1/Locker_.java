package jpabook.associcate1;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Locker.class)
public abstract class Locker_ {

	public static volatile SingularAttribute<Locker, String> name;
	public static volatile SingularAttribute<Locker, Member> member;
	public static volatile SingularAttribute<Locker, Long> id;

}

