package myProject.shortURL.usedUrl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import myProject.shortURL.notUsedUrl.NotUsedUrl;
import myProject.shortURL.notUsedUrl.NotUsedUrlRepository;

@RestController
@CrossOrigin(origins ="https://jisung-choi.github.io")
@RequestMapping("/api/uu")
public class UsedUrlRestController {
    
    @Autowired
    private UsedUrlRepository usedUrlRepository;
    @Autowired
    private NotUsedUrlRepository notUsedUrlRepository;

    @GetMapping("/get/{id}")
    public UsedUrl findBy_id(@PathVariable String id){
        return usedUrlRepository.findBy_id(id);
    }

    //Needs to be tested
    @PostMapping("/register")
    public UsedUrl save(@RequestBody UsedUrl usedUrl){
        System.out.println("save is called" + usedUrl.get_id());
        usedUrlRepository.save(usedUrl);
        return usedUrl;
    }

    @Scheduled(cron = "0 55 14 7 8 ?") // Runs at 04:00 on the 1st day of each month
    public void purgeExpiredDocuments() {
        //collect list of dates
        List<String> datesList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalDate oneMonthAgo = currentDate.minusMonths(1);
        while (oneMonthAgo.isBefore(currentDate)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = oneMonthAgo.format(formatter);
            datesList.add(formattedDate);
            oneMonthAgo = oneMonthAgo.plusDays(1);
        }
        //run deleteBy in forLoop
        // for (String date : datesList) {
        //     for(UsedUrl usedUrl: usedUrlRepository.findByexpirationDate(date)){
        //         String id = usedUrl.get_id();
        //         NotUsedUrl nuu = new NotUsedUrl(id);
        //         notUsedUrlRepository.save(nuu);
        //         usedUrlRepository.deleteBy_id(id);
        //     }
        // }
    }
}
