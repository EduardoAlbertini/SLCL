package br.com.hibernate;

import br.com.entitys.Curso;
import br.com.entitys.Disciplina;
import br.com.entitys.Evento;
import br.com.entitys.Livro;
import br.com.entitys.Usuario;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateConfiguration {

    public static final String userName = "root";
    public static final String password = "root";
    public static final String dataBase = "SLCL";
    private static AnnotationConfiguration cfg = null;
    private static SessionFactory factory = null;
    
    @Deprecated
    public static SessionFactory getSessionFactory() {
        if (cfg == null) {
            cfg = new AnnotationConfiguration();
            cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.username", userName);
            cfg.setProperty("hibernate.connection.password", password);
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/" + dataBase);
            cfg.setProperty("hibernate.show_sql", "false");
            cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            cfg.setProperty("hibernate.connection.autocommit", "true");

            cfg.addAnnotatedClass(Usuario.class);
            cfg.addAnnotatedClass(Evento.class);
            cfg.addAnnotatedClass(Livro.class);
            cfg.addAnnotatedClass(Curso.class);
            cfg.addAnnotatedClass(Disciplina.class);

            factory = cfg.buildSessionFactory();
        }
        return factory;
    }
}
