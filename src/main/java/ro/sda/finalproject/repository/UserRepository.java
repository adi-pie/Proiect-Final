package ro.sda.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.finalproject.model.User;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    public List<User> findAll();

    public Optional<User> findUserByEmail(String email);

    //@Query("SELECT u FROM User u WHERE u.username=?ELI")
    public Optional<User> findUserByUsername(String username);


}


