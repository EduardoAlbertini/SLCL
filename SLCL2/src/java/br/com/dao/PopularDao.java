package br.com.dao;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class PopularDao {
    private static Configuration conf;

    static {
        conf = new AnnotationConfiguration();
        conf.configure();
    }

    public static void limparBanco() {
    }

    public static void criarBanco() {
        SchemaExport se = new SchemaExport(conf);
        se.create(true, true);
    }
}