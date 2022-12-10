package platform.database;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.domain.CodeSnippet;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<CodeSnippet, UUID> {
    @Query(value="SELECT * FROM code_snippet c WHERE c.expiry_date IS NULL AND c.available_views IS NULL ORDER BY c.date DESC LIMIT ?1", nativeQuery = true)
    public List<CodeSnippet> getLatest(int n);

    @Modifying
    @Query(value="DELETE FROM code_snippet c WHERE (c.expiry_date < ?1 OR c.available_views <= 0)", nativeQuery = true)
    public void validateExpiry(LocalDateTime now);

    public default void validateExpiry(){
        validateExpiry(LocalDateTime.now());
    }

    @Modifying
    @Query(value = "UPDATE code_snippet c SET c.available_views = c.available_views-1 WHERE c.id=?1 AND c.available_views IS NOT NULL", nativeQuery = true)
    public void updateCodeView(UUID id);
}