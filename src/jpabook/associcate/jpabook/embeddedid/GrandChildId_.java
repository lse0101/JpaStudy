package jpabook.embeddedid;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GrandChildId.class)
public abstract class GrandChildId_ {

	public static volatile SingularAttribute<GrandChildId, ChildId> childId;
	public static volatile SingularAttribute<GrandChildId, String> grandChildId;

}

