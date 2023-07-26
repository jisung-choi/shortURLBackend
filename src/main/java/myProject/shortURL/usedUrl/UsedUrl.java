package myProject.shortURL.usedUrl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "used")
public class UsedUrl {
    @Id
    private String _id;
    private String originalURL;
    private String expirationDate;

    public UsedUrl() {
        
    }

    public UsedUrl(String _id, String originalURL, String expirationDate){
        this._id = _id;
        this.originalURL = originalURL;
        this.expirationDate = expirationDate;
    }

    public void set_id(String id){
        this._id = id;
    }

    public String get_id(){
        return _id;
    }

    public void setOriginalURL(String url){
        this.originalURL = url;
    }

    public String getOriginalURL(){
        return originalURL;
    }

    public void setExpirationDate(String date){
        this.expirationDate = date;
    }

    public String getExpirationDate(){
        return expirationDate;
    }
}
