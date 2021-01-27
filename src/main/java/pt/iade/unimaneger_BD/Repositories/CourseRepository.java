package pt.iade.unimanager_db.models;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Modifying
    @Transactional
    @Query(value="Insert into planoestudos "+"(pla_cur_id,pla_dis_id,pla_semestre) "+"values(:#{#plan.course.id}, "+":#{#plan.unit.id},:#{#plan.semester})",nativeQuery=true)
    void addUnitToCourse(@Param("plan") Plan plan);
}