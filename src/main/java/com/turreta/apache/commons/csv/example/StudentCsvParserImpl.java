package com.turreta.apache.commons.csv.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class StudentCsvParserImpl implements StudentCsvParser {

    public List<StudentDTO> parseCsv(String fileName) throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        List<StudentDTO> studentList = new ArrayList<>();

        Reader in = new FileReader(file);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader().parse(in);
        for (CSVRecord record : records) {
            StudentDTO dto = new StudentDTO();
            dto.setStudentId(Integer.parseInt(record.get("STUDENT_ID")));
            dto.setFirstName(record.get("FIRST_NAME"));
            dto.setLastName(record.get("LAST_NAME"));
            dto.setMiddleName(record.get("MIDDLE_NAME"));
            studentList.add(dto);
        }
        return studentList;
    }

}
