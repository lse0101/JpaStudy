package jpabook.start;

import javax.persistence.*;

/**
 * Created by lse0101 on 2017-02-13.
 */
@Entity
@Table(name = "BOARD")
@TableGenerator(name="BOARD_SEQ_GENERATOR",
                initialValue = 1,
                allocationSize = 50)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "BOARD_SEQ_GENERATOR")
    private Long id;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
