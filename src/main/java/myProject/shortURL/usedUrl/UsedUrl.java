package myProject.shortURL.usedUrl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "used")
public class UsedUrl {
    @Id
    private String _id;
    private String originalURL;
    private String expirationDate;

    public UsedUrl(String _id, String originalURL, String expirationDate){
        this._id = _id;
        this.originalURL = originalURL;
        // LocalDateTime currentTime = LocalDateTime.now();
        // DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // //add +1 year to currentTime later
        // this.expirationDate = currentTime.format(formattedTime);
        this.expirationDate = expirationDate;
    }

    public String getID(){
        return _id;
    }

    public void setOriginalURL(String url){
        this.originalURL = url;
    }

    public String getOriginalURL(){
        return originalURL;
    }
}
