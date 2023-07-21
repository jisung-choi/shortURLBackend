package myProject.shortURL;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.aggregation.ComparisonOperators.Eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters.*;


@SpringBootApplication
public class ShortUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShortUrlApplication.class, args);
		
		//Change to env variable later
		// String connectionString = "mongodb+srv://qlelwltjd:TNx9s7ABTdPEtiAr@cluster0.fibtsgz.mongodb.net/?retryWrites=true&w=majority";

		// MongoClient client = MongoClients.create(connectionString);

		// MongoDatabase db = client.getDatabase("urls");

		// MongoCollection notUsed = db.getCollection("notUsed");
		// MongoCollection used = db.getCollection("used");

		// Document sample = new Document("_id", "https").append("originalURL", "https").append("expirationDate", "actualDate");

		// notUsed.insertOne(sample);

		// Object myDoc = notUsed.find().first();
		// System.out.println(((Document) myDoc).toJson());
		// notUsed.deleteOne((new Document("_id", ((Document) myDoc).get("_id"))));
		
		// ((Document) myDoc).put("originalURL", "userInputURL");
		// used.insertOne(myDoc);

	}

}
