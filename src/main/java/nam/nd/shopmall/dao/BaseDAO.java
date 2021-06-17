package nam.nd.shopmall.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 17/06/2021 - 7:27 PM
 */
public interface BaseDAO {

    <T> List<T> findAll(Class<T> clazz);

    <T> Optional<T> findById(Serializable id, Class<T> clazz);

    <T> Serializable save(T entity);

    <T> void update(T entity);

    <T> void delete(T entity);
}
