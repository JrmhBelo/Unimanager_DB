package pt.iade.unimanager_db.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

@Entity @Table(name="alunos")
public class Student {
    @Id @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="alu_id") private int id;
    @Column(name="alu_nome") private String name;
    @Column(name="alu_local") private String local;
    @Column(name="alu_dnsc") private Date dnsc;
    @Column(name="alu_sexo") private char sexo;
    @Column(name="alu_email") private String email;
    @ManyToOne @MapsId("courseId") @JoinColumn(name="alu_cur_id")
    @JsonIgnoreProperties("planoestudos")
    private Course course;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDnsc() {
        return dnsc;
    }

    public void setDnsc(Date dnsc) {
        this.dnsc = dnsc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}