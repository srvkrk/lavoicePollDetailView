package com.lavoice.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
	@Override
    protected String getDatabaseName() {
        return "lavoice";
    }
  
    @Override
    protected String getMappingBasePackage() {
        return "com.lavoice";
    }

	@Override
	public MongoClient mongoClient() {
		return new MongoClient("127.0.0.1", 27017);
	}
}
