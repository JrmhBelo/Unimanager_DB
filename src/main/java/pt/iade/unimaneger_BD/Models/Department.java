package pt.iade.unimanager_db.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity @Table(name="departamentos")
public class Department {
    @Id @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Column(name="dep_id") private int id;
    @Column(name="dep_nome") private String nome;
    @Column(name="dep_sigla") private String sigla;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}