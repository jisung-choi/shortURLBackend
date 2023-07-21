package myProject.shortURL.notUsedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/NotUsedUrl")
public class NotUsedUrlRestController {
    
    @Autowired
    private NotUsedUrlRepository notUsedUrlRepository;

    @PostMapping("/{id}")
    public NotUsedUrl save(@PathVariable String id) {
        System.out.println("save activated");
        return notUsedUrlRepository.save(new NotUsedUrl(id));
    }

    @GetMapping("/{id}")
    public NotUsedUrl findBy_id(@PathVariable String id) {
        System.out.println("findById is called with id: " + id);
        NotUsedUrl result = notUsedUrlRepository.findBy_id(id);
        System.out.println("findById result: " + result);
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteBy_id(@PathVariable String id){
        notUsedUrlRepository.deleteBy_id(id);
    }
}
