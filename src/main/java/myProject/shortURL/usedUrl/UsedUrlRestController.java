package myProject.shortURL.usedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UsedUrl")
public class UsedUrlRestController {
    
    @Autowired
    private UsedUrlRepository usedUrlRepository;

    @GetMapping(value = "/getOriginalUrl")
    public String getOriginalUrlById(String id){
        return usedUrlRepository.getOriginalUrlBy_id(id);
    }

    @PostMapping(value = "/save")
    public UsedUrl save(UsedUrl url){
        return usedUrlRepository.save(url);
    }
}
