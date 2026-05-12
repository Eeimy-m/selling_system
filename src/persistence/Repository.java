package persistence;

public interface Repository<K, V> {
    void save(V value);
    void update(V value);
    V findById(K id);
    //previna que métodos de consulta venham a retornar objetos nulos
}
