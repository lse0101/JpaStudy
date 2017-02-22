package jpabook.start;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Member.class)
public abstract class Member_ {

	public static volatile SingularAttribute<Member, Date> createdDate;
	public static volatile SingularAttribute<Member, Date> lastModifiedDate;
	public static volatile SingularAttribute<Member, String> description;
	public static volatile SingularAttribute<Member, String> id;
	public static volatile SingularAttribute<Member, RoleType> roleType;
	public static volatile SingularAttribute<Member, Integer> age;
	public static volatile SingularAttribute<Member, String> username;

}

