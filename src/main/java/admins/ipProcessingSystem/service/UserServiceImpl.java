package admins.ipProcessingSystem.service;

import admins.ipProcessingSystem.dao.UserDao;
import admins.ipProcessingSystem.entity.IpDetails;
import admins.ipProcessingSystem.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    public UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Users findByUserId(int userId) {
        return userDao.findByUserId(userId);
    }

    @Override
    public void save(IpDetails ipDetails) {
        userDao.save(ipDetails);
    }

    @Override
    public void update(IpDetails ipDetails) {
        userDao.update(ipDetails);
    }


    @Override
    public List<IpDetails> findIpByUserId(int userId) {
        return userDao.findIpByUserId(userId);
    }
}
