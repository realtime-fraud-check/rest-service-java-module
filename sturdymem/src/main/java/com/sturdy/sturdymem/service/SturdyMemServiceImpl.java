package com.sturdy.sturdymem.service;

import com.sturdy.sturdymem.dao.MyRepository;
import com.sturdy.sturdymem.entity.MyResource;
import com.sturdy.sturdymem.util.SturdyHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SturdyMemServiceImpl implements SturdyMemService {

    private Logger logger = LoggerFactory.getLogger(SturdyHelper.class);

    @Autowired
    private MyRepository myRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveToDictionary(MultipartFile file) {
        //parse the file
        List<String> strings = SturdyHelper.parseFile(file);
        myRepository.save(new MyResource("MyDictionary",strings));
    }

    @Override
    public boolean findIfTargetWordExists(String targetWord) {

        TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
                .onField("values", 2F)
                .build();
        mongoTemplate.indexOps(MyResource.class).ensureIndex(textIndex);

        TextCriteria criteria = TextCriteria.forDefaultLanguage()
                .matching(targetWord);

        Query query = TextQuery.queryText(criteria);
        logger.debug("About to search  for {}", targetWord);
        List<MyResource> searchResults = mongoTemplate.find(query, MyResource.class);
        logger.debug("searchResults retrieved {} ", searchResults);
        return null != searchResults && !searchResults.isEmpty();
    }
}
