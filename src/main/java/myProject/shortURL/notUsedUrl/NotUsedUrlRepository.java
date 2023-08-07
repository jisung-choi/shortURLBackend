package myProject.shortURL.notUsedUrl;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//SpringBoot repositories have to follow CRUD syntax from here 
//https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result

@Repository
public interface NotUsedUrlRepository extends MongoRepository<NotUsedUrl, String>{
    NotUsedUrl findBy_id(String _id);
    void deleteBy_id(String _id);
    NotUsedUrl save(NotUsedUrl url);

    @Aggregation(pipeline = { "{ $sample: { size: 1 } }" })
    NotUsedUrl findRandomDocument();
}
