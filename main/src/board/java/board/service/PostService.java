package board.service;

import board.domain.Post;
import board.domain.User;
import board.repository.PostRepository;
import board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    /**
     * 게시글 등록
     */
    public Long posting(Long userId, String name, String content) {
        // 게시글 작성 회원 조회
        User user = userRepository.findById(userId);

        // 게시글 작성
        Post post = Post.createPost(user, name, content);

        // 게시글 저장
        postRepository.save(post);

        return post.getPostId();
    }

    /**
     * 게시글 번호를 통한 게시글 조회
     */
    @Transactional(readOnly = true)
    public Post findPostById(Long postId) {
        Post post = postRepository.findById(postId);

        return post;
    }

    /**
     * 게시글 삭제
     */
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    /**
     * 게시글 수정
     */
    public void updatePost(Long postId, String name, String content) {
        Post post = postRepository.findById(postId);
        post.setPostName(name);
        post.setContent(content);
    }
}
