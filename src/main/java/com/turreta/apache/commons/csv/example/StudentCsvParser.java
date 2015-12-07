package com.turreta.apache.commons.csv.example;

import java.io.IOException;
import java.util.List;

public interface StudentCsvParser {

    List<StudentDTO> parseCsv(String fileName) throws IOException;

}
