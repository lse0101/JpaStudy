package jpabook.associcate1;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ {

	public static volatile SingularAttribute<Member, String> id;
	public static volatile SingularAttribute<Member, String> team_id;
	public static volatile SingularAttribute<Member, Locker> locker;
	public static volatile SingularAttribute<Member, String> username;

}

