package org.example.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    String getFromDataFile(String fileName) throws IOException;
    boolean writeDataFromFile(List<String> users, String fileName);
}
