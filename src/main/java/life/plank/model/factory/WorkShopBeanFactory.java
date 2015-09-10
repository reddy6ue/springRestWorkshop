package life.plank.model.factory;

import life.plank.model.Author;
import life.plank.model.Student;
import org.springframework.stereotype.Component;

/**
 * Created by Praneeth on 8/26/2015.
 */
@Component
public class WorkShopBeanFactory {
    public Author createAuthorInstance(String fullName) {
        return Author.createInstance(fullName);
    }

    public Student createStudentInstance(String fullName) {
        return Student.createStudentInstance(fullName);
    }
}
