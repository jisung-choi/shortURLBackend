package myProject.shortURL.usedUrl;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedUrlRepository extends MongoRepository<UsedUrl, String>{
    String getOriginalUrlBy_id(String id);
    UsedUrl save(UsedUrl url);
}
