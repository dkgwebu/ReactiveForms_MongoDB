

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test;

import com.mongodb.DBCursor;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.bson.types.ObjectId;
import com.mongodb.client.model.Filters;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dkgwebu
 */
public class MongoDBConnect {
    
    public static void main(String[] args) {   	

                String user = "db_covid"; // 
                String database = "covid"; 
                String password = "Dumi@94"; 
                

            MongoCredential credential = MongoCredential.createCredential(user, database, password.toCharArray());   
            MongoClientOptions options = MongoClientOptions.builder().sslEnabled(true).build();
        

        try (MongoClient mongoClient = new MongoClient(new ServerAddress("cluster0-shard-00-00.pnffd.mongodb.net", 27017),
                                       Arrays.asList(credential),options);
            ){ 
            MongoDatabase db_covid = mongoClient.getDatabase(database);	
            
            
          MongoCollection<Document> collection = db_covid.getCollection("Registration");         
          Document query = new Document("_id", new ObjectId("61384e36a8a9b7f92d84e484"));
//          Document result = collection.find(query).iterator().next();
                                    
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    } 
 
}
