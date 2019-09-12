package com.sturdy.sturdymem.service;

import com.sturdy.sturdymem.dao.MyRepository;
import com.sturdy.sturdymem.entity.MyResource;
import com.sturdy.sturdymem.exception.ServiceException;
import com.sturdy.sturdymem.util.SturdyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SturdyMemServiceImpl implements SturdyMemService {

    @Autowired
    private MyRepository myRepository;

    @Override
    public void init() {

    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveToDictionary(MultipartFile file) {

        //parse the file
        List<String> strings = SturdyHelper.parseFile(file);

        myRepository.save(new MyResource("MyDictionary",strings));

        List<MyResource> all = myRepository.findAll();
        System.out.println("Debug$$$" + all);
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new ServiceException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new ServiceException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                System.out.println();
            }
        }
        catch (IOException e) {
            throw new ServiceException("Failed to store file " + filename, e);
        }

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public boolean findIfTargetWordExists(String targetWord) {

        TextIndexDefinition textIndex = new TextIndexDefinition.TextIndexDefinitionBuilder()
                .onField("values", 2F)
                .build();
        mongoTemplate.indexOps(MyResource.class).ensureIndex(textIndex);


        TextCriteria criteria = TextCriteria.forDefaultLanguage()
                .matching(targetWord);

        Query query = TextQuery.queryText(criteria)
                .sortByScore()
                .with(new PageRequest(0, 5));

        List<MyResource> found = mongoTemplate.find(query, MyResource.class);
        return !found.isEmpty();
    }
}
