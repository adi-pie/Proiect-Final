package ro.sda.finalproject.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.finalproject.model.User;
import ro.sda.finalproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }


    public void save(User user) {
        userRepository.save(user);
    }

    public User get(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("Could not find any users with ID" + userId);
    }

    public void delete(Long userId) throws UserNotFoundException {
        userRepository.findById(userId).orElseThrow(() -> new
                UserNotFoundException("Could not find any users with ID" + userId));
        userRepository.deleteById(userId);
        /*
      Long count = userRepository.countByuserId(userId);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with ID" + userId);
        }

         */
    }
}
