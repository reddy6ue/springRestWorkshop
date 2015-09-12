package life.plank.repository;

import life.plank.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Praneeth on 9/10/2015.
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
