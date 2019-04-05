package com.villains.dataset.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class Generator {

    private static final Logger logger = LoggerFactory.getLogger(Generator.class);

    public <T> T generateDummyObjFromJson(String fileName, Class<T> modelClass) {
        ObjectMapper mapper = new ObjectMapper();
        T model = null;
        try {
            model = mapper.readValue(new File(ClassLoader.getSystemResource(fileName).getFile()), modelClass);
            logger.debug("Object from {} generated succesfully: {}", modelClass, model);
        } catch (IOException exc) {
            logger.error("Error reading resource file " + fileName, exc);
        }
        return model;
    }

}
