package lv.unversityManagementSystem.repository;

import lv.unversityManagementSystem.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Modifying
//    @Query("delete from users where users.id = ?1 " +
//            "left join employees on users.id = employees.user_id " +
//            "left join students on users.id = students.user_id")
    void deleteUserById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findUserById(Long id);

//    @Query("select u from users u where u.username = : username")
//    public User getUserByUsername(@Param("username") String username);


}