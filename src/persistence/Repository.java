package persistence;

import java.util.Optional;

public interface Repository<K, V> {
    void save(V value);
    void update(V value);
    Optional<V> findById(K id);
}
