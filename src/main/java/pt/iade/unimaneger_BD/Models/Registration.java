package pt.iade.unimanager_db.models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity @Table(name="inscricoes")
public class Registrations {
    @Id @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="ins_id") private int id;
    @Column(name="ins_dt_inscricao") private Date insc;
    @Column(name="ins_dt_avaliacao") private Date aval;
    @Column(name="ins_dt_nota") private double nota;
}