package myProject.shortURL.notUsedUrl;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notUsed")
public class NotUsedUrl {
    @Id
    private String _id;

    public NotUsedUrl(){}

    public NotUsedUrl(String id){
        this._id = id;
    }

    public String get_id(){
        return this._id;
    }

    public void set_id(String id){
        this._id = id;
    }
}
