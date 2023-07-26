package myProject.shortURL.notUsedUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//(origins ="https://jisung-choi.github.io")
@RequestMapping("/api/nuu")
public class NotUsedUrlRestController {
    
    @Autowired
    private NotUsedUrlRepository notUsedUrlRepository;

    //Gets and Deletes a random document from collection
    @GetMapping("/get")
    public NotUsedUrl findRandomDocument(){
        System.out.println("findById is called with id");
        NotUsedUrl result = notUsedUrlRepository.findRandomDocument();
        notUsedUrlRepository.delete(result);
        System.out.println("findById result: " + result);
        return result;
    }
}