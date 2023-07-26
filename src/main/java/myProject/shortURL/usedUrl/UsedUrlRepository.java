package myProject.shortURL.usedUrl;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//SpringBoot repositories have to follow CRUD syntax from here 
//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result

@Repository
public interface UsedUrlRepository extends MongoRepository<UsedUrl, String>{
    UsedUrl findBy_id(String _id);
    UsedUrl save(UsedUrl url);
    Long deleteByexpirationDate(String date);
}
