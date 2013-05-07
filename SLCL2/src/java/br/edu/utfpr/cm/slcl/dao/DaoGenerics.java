package br.com.dao;


import br.com.hibernate.HibernateConfiguration;
import br.com.ldap.TransactionManager;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DaoGenerics<T> implements Dao<T> {

    protected Session session =  TransactionManager.getCurrentSession();  
    protected Class classe;

    @Override
    public void persistir(T o) {       
        session.saveOrUpdate(o);
        session.flush();
    }

    @Override
    public void remover(T o) {
        session.delete(o);
        session.flush();
    }

    @Override
    public T obterPorId(int id) {
        T objeto = null;
        if (id > 0) {
            Query select = session.createQuery("From "+classe.getSimpleName()+" where id = " + id);
            objeto = (T) select.uniqueResult();
        }
        return objeto;
    }

    @Override
    public List<T> listar(String filtro) {        
        List<T> lista = null;
        if (filtro != null) {
            session = HibernateConfiguration.openConnect();
            Query query = session.createQuery(filtro);
            lista = query.list();
        }
        return lista;        
    }
    
    public List<T> listar() {        
        List<T> lista = null;
            String filtro = "From " + classe.getSimpleName();
            session = HibernateConfiguration.openConnect();
            Query query = session.createQuery(filtro);
            lista = query.list();
        
        return lista;        
    }
    
    public List<T> consultaSql(String Sql) {
        return (List<T>) session.createSQLQuery(Sql).addEntity(classe).list();
    }
}