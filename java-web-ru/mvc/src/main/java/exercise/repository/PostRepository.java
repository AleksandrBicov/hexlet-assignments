package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import exercise.model.Post;
import lombok.Getter;

import java.util.Optional;

public class PostRepository {
    @Getter
    private static List<Post> entities = new ArrayList<>();

    public static void save(Post post) {
        if (post.getId() == null) {
            post.setId((long) entities.size() + 1);
            entities.add(post);
        }
    }

    public static List<Post> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
    }

    public static Optional<Post> find(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    public static Optional<Post> findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny();
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

    public static void clear() {
        entities.clear();
    }
}
