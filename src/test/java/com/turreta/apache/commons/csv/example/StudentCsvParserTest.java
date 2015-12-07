package com.turreta.apache.commons.csv.example;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StudentCsvParserTest {

    private StudentCsvParser parser;

    @Before
    public void setUp() throws Exception {
        parser = new StudentCsvParserImpl();
    }

    @Test
    public void testParseCsv() {
        try {
            List<StudentDTO> dtoList = parser.parseCsv("sample-data.csv");
            for (StudentDTO dto : dtoList) {
                System.out.println("**********");
                System.out.println("USER_ID:" + dto.getStudentId());
                System.out.println("LAST_NAME:" + dto.getLastName());
                System.out.println("MIDDLE_NAME:" + dto.getMiddleName());
                System.out.println("FIRST_NAME:" + dto.getFirstName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
