package jpabook.jointable;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Parent.class)
public abstract class Parent_ {

	public static volatile SingularAttribute<Parent, String> name;
	public static volatile SingularAttribute<Parent, Long> id;
	public static volatile SingularAttribute<Parent, Child> child;

}

