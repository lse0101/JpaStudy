package jpabook.secondarytable;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Board.class)
public abstract class Board_ {

	public static volatile SingularAttribute<Board, Long> id;
	public static volatile SingularAttribute<Board, String> title;
	public static volatile SingularAttribute<Board, String> content;

}

