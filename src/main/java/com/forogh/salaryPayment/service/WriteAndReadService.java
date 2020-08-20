package com.forogh.salaryPayment.service;

import com.forogh.salaryPayment.model.ModelType;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class WriteAndReadService {
    private final String resource = "src/main/resources/";
    private static final Logger log = Logger.getLogger(WriteAndReadService.class.getName());

    Object readFile(ModelType modelType) throws ClassNotFoundException {
        Object fileValues = null;
        try {
            Path path = Paths.get(resource + modelType.getName() + ".txt");
            byte[] contents = Files.readAllBytes(path);
            fileValues = deserialize(contents);
            log.info("Read on file is successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileValues;
    }

    void writeOnFile(Object models, ModelType modelType) {
        try {
            Path path = Paths.get(resource + modelType.getName() + ".txt");
            Files.write(path, serialize(models));
            log.info("Write on file is successfully");
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    private Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}
