package admins.ipProcessingSystem.dao;

import admins.ipProcessingSystem.entity.Admin;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AdminHibernateImpl implements AdminDao{


    private EntityManager entityManager;


    public AdminHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Admin admin) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(admin);
    }

    @Override
    public void save(Users users) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(users);
    }

    @Override
    public List<IpDetails> findAllIp() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<IpDetails> theQuery = currentSession.createQuery("From IpDetails",IpDetails.class );

        List<IpDetails> ipDetails = theQuery.getResultList();
        return ipDetails;
    }

    @Override
    public List<Users> findByAdminId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Users> theQuery = currentSession.createQuery("From Users where adminId =:Id",Users.class );
        theQuery.setParameter("Id", id);
        List<Users> users = theQuery.getResultList();
        return users;
    }

}
