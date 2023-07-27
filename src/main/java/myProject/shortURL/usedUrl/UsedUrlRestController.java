package myProject.shortURL.usedUrl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//(origins ="https://jisung-choi.github.io")
@RequestMapping("/api/uu")
public class UsedUrlRestController {
    
    @Autowired
    private UsedUrlRepository usedUrlRepository;

    //returns original url
    //replace below with github page link
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

    @Scheduled(cron = "0 0 4 1 * ?") // Runs at 04:00 on the 1st day of each month
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
        for (String date : datesList) {
            usedUrlRepository.deleteByexpirationDate(date);
        }
    }
}
