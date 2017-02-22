package jpabook.associcate1;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ {

	public static volatile ListAttribute<Team, Member> members;
	public static volatile SingularAttribute<Team, String> name;
	public static volatile SingularAttribute<Team, String> id;

}

