package board.domain;

import javax.persistence.*;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long postId;

    private String postName;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
