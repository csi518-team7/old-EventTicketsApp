package us.team7pro.EventTicketsApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import us.team7pro.EventTicketsApp.Models.User;
import us.team7pro.EventTicketsApp.Repositories.UserRepository;

public class UserServiceJpaImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUserById(int usrID) {
        return userRepository.findByUserID(usrID);
    }
}
