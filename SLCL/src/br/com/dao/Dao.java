package br.com.dao;

import java.util.List;
import org.hibernate.Session;

public class Dao<T> {

    private Class classe;
    private Session session;

    public Dao(Class classe) {
        this.session = HibernateUtil.getSession();
        this.classe = classe;
    }

    public void save(T t) {
       this.session = HibernateUtil.getSession();
        this.session.save(t);
        this.session.close();
    }

    public void delete(T t) {
        this.session.beginTransaction();
        this.session.delete(t);
        this.session.close();
    }

    public void alter(T t) {
        this.session.beginTransaction();
        this.session.update(t);
        this.session.close();
    }

    public T procura(Integer id) {
        // TODO Auto-generated method stub
        return (T) session.load(this.classe, id);
    }

    public List<T> findAll(T t) {
        this.session.beginTransaction();
        return this.session.createCriteria(this.classe).list();
    }

    public List<T> findAllLimit(int limite) {
        List<T> list;
        this.session.beginTransaction();
        list = this.session.createCriteria(this.classe).setMaxResults(limite).list();
        this.session.close();
        return list;
    }

    public List<T> consultaSql(String Sql) {
        return (List<T>) session.createSQLQuery(Sql).addEntity(classe).list();
    }
}
