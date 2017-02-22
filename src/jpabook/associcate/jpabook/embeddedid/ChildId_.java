package jpabook.embeddedid;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChildId.class)
public abstract class ChildId_ {

	public static volatile SingularAttribute<ChildId, String> id;
	public static volatile SingularAttribute<ChildId, String> parentId;

}

