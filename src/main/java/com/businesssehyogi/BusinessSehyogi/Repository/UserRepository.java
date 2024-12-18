package com.businesssehyogi.BusinessSehyogi.Repository;

import com.businesssehyogi.BusinessSehyogi.DTO.loginDTO;
import com.businesssehyogi.BusinessSehyogi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmailIgnoreCase(String email);

    @Query("""
                SELECT u FROM User u WHERE u.userId NOT IN (
                    SELECT c.coFounderOrInvestorUser.userId 
                    FROM Connections c 
                    WHERE c.founderUser.userId = :currentUserId AND c.status = 'Accept'
                ) AND u.userId NOT IN (
                    SELECT c.founderUser.userId 
                    FROM Connections c 
                    WHERE c.coFounderOrInvestorUser.userId = :currentUserId AND c.status = 'Accept'
                ) AND u.userId <> :currentUserId
            """)
    List<User> findAvailableUsers(@Param("currentUserId") int currentUserId);

    User findByEmail(String email);

    @Query("SELECT new com.businesssehyogi.BusinessSehyogi.DTO.loginDTO(u.userId, u.email, u.password, u.category, u.visible) FROM User u WHERE u.email = :email")
    loginDTO login(@Param("email") String email);

    Optional<User> findByUserId(int userId);
}
