package com.example.demo.mongo;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestConnection {
	
	public static void main(String[] args) {
		
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		MongoDatabase database = mongoClient.getDatabase("test");
		
		MongoCollection<org.bson.Document> collection= database.getCollection("student");
		
		Document myDoc = collection.find().first();
		String json = myDoc.toJson();
		System.out.println(json);
	}
}
