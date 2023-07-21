package myProject.shortURL.usedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/uu")
public class UsedUrlRestController {
    
    @Autowired
    private UsedUrlRepository usedUrlRepository;

    //returns original url
    @GetMapping("/get/{id}")
    public String findBy_id(@PathVariable String id){
        UsedUrl url = usedUrlRepository.findBy_id(id);
        String original = url.getOriginalURL();
        return original;
    }

    //registers a new usedURL
    @PostMapping("/register/{id}/{original}")
    public String save(@PathVariable String id, @PathVariable String original){
        UsedUrl url = new UsedUrl(id, original);
        usedUrlRepository.save(url);
        return url.get_id();
    }
}
