package admins.ipProcessingSystem.dao;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Users findByUserId(int userId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Users users = currentSession.get(Users.class,userId);
        return users;
    }
    @Override
    public void save(IpDetails ipDetails) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(ipDetails);
    }
    @Override
    public void update(IpDetails ipDetails) {

        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(ipDetails);
    }


    @Override
    public List<IpDetails> findIpByUserId(int userId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<IpDetails> theQuery = currentSession.createQuery("From IpDetails where userId =:Id",IpDetails.class );
        theQuery.setParameter("Id", userId);
        List<IpDetails> ipDetails = theQuery.getResultList();

        return ipDetails;
    }

}
