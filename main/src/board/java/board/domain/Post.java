package board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    private String postName;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    /**
     * 생성 메서드
     * 글이 작성될 때 reply, comments는 없다고 가정
     */
    public static Post createPost(User user, String name, String content) {
        Post post = new Post();
        post.setPostName(name);
        post.setUser(user);
        post.setContent(content);

        return post;
    }
}
