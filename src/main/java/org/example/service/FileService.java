package org.example.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileService {
    String getFromDataFile(String fileName) throws IOException;
    boolean writeDataFromFile(String info, String fileName);
}
