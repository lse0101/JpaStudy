package jpabook.embeddedid;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GrandChild.class)
public abstract class GrandChild_ {

	public static volatile SingularAttribute<GrandChild, String> name;
	public static volatile SingularAttribute<GrandChild, GrandChildId> id;
	public static volatile SingularAttribute<GrandChild, Child> child;

}

