package jpabook.embeddedid;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Child.class)
public abstract class Child_ {

	public static volatile SingularAttribute<Child, Parent> parent;
	public static volatile SingularAttribute<Child, String> name;
	public static volatile SingularAttribute<Child, ChildId> id;

}

