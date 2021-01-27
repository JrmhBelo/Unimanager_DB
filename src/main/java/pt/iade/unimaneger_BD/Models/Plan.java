package pt.iade.unimanager_db.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

@Entity @Table(name="planoestudos")
@IdClass(PlanId.class)
public class Plan {
    @Id @Column(name ="pla_cur_id")
    @JsonIgnore private int courseId;
    @ManyToOne @MapsId("courseId") @JoinColumn(name="pla_cur_id")
    @JsonIgnoreProperties("planoestudos")
    private Course course;
    @Column(name="pla_semestre") private int semester;
    @Id @Column(name ="pla_dis_id")
    @JsonIgnore private int unitId;
    @ManyToOne @MapsId("unitId")
    @JoinColumn(name ="pla_dis_id")
    @JsonIgnoreProperties("plans")
    private Unit unit;
    public Plan() {}

    public int getCourseId() {
        return courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getUnitId() {
        return unitId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}