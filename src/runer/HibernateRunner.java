package runer;


import com.sun.xml.bind.api.impl.NameConverter;
import entity.UserEntity;
import org.apache.tools.ant.taskdefs.Local;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateRunner {
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        StandardServiceRegistry registry = builder.build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("from UserEntity where id = 1");
        //query.setParameter("id", 1);
        List list = query.list();
        list.stream().forEach(o -> System.out.println(((UserEntity) o).getSurname()));
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
