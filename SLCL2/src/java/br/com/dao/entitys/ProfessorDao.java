package br.com.dao.entitys;

import br.com.dao.Dao;
import br.com.entitys.Professor;

public class ProfessorDao extends Dao<Professor> {
    public ProfessorDao() {
        super(Professor.class);
    }
}
