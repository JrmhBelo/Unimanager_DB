package pt.iade.unimanager_db.models;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UnitRepository extends CrudRepository<Unit, Integer> {
    Iterable<Unit> findByName(String name);
    Iterable<Unit> findByNameLike(String name);
    Iterable<Unit> findByCreditsBetween(int min,int max);
    Iterable<Unit> findByNameLikeAndByCreditsBetween(String name,int min,int max);
    String QueryFindUnitPlans = "…";
    @Query(value=QueryFindUnitPlans, nativeQuery=true)
	static
    Iterable<UnitPlanView> findAllUnitPlans() {
		return null;
    }
    
    @Query(value = QueryFindUnitPlans +" Where u.dis_id=:id", nativeQuery = true)
    Iterable<UnitPlanView> findUnitPlansById(
    @Param("id") int id);
    @Query( value = QueryFindUnitPlans +" Where u.dis_id=:idUnit and c.cur_id=:idCourse",nativeQuery = true)
    Optional<UnitPlanView> findUnitPlanByUnitAndCourse(
    @Param("idUnit") int idUnit,
    @Param("idCourse") int idCourse);
}