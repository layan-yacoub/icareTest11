package com.example.icare.icare.token;/*package com.example.icare.token;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.user_id = u.user_id\s
      where u.user_id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Integer user_id);

    Optional<Token> findByToken(String token);

}
*/