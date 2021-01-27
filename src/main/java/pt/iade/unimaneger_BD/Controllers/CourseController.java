package pt.iade.unimanager_db.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.bytebuddy.asm.MemberSubstitution.Substitution.ForMethodInvocation.MethodResolver.Simple;
import pt.iade.unimanager_db.models.Plan;
import pt.iade.unimanager_db.models.Unit;
import pt.iade.unimanager_db.models.UnitPlanView;
import pt.iade.unimanager_db.models.UnitRepository;
import pt.iade.unimanager_db.models.exceptions.NotFoundException;

public class CourseController {
    @PostMapping(path = "/{courseId}/units", produces = MediaType.APPLICATION_JSON_VALUE)
    public SimpleResult saveUnitInCourse(   
        @RequestBody Plan plan) {
        logger.info("Adding unit with id " +plan.getUnit().getId());
        courseRepository.addUnitToCourse(plan);
        return new SimpleResult("Added unit with id "+
        plan.getUnit().getId(),plan);
    }
}