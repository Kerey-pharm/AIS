package kz.kerey.mongo.test;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Main {

	
	
	public static void main(String[] args) throws UnknownHostException {

		MongoClient mongo = new MongoClient("localhost", 27017);
	
		DB db = mongo.getDB("daka");
		
		DBCollection table = db.getCollection("daka");
		
		BasicDBObject query = new BasicDBObject();
		query.put("name", "daka");
		
		DBCursor cursor = table.find(query);
		
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
	}

	
	
}
