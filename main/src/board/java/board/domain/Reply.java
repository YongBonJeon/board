package board.domain;

import javax.persistence.*;

@Entity
public class Reply {

    @Id @GeneratedValue
    private Long replyId;

    private String replyName;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

}
