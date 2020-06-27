package other;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * @author baojunjie
 * @date 2019-04-30.
 */
public class SqlSessionAssist {
    public static SqlSessionFactory sessionFactory;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("yusys-mybatis-config.xml");
            // InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }
}
