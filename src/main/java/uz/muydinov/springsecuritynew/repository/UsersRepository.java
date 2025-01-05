package uz.muydinov.springsecuritynew.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.muydinov.springsecuritynew.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
