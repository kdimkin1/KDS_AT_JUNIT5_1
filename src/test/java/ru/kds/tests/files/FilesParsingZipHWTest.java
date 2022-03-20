package ru.kds.tests.files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingZipHWTest {

//    ClassLoader classLoader = getClass().getClassLoader();

    // Constants
    private static final String
            CSV_FILE = "CSV_TEST_DATA.csv",  //file should be in UTF-8
            PDF_FILE = "PDF_TEST_DATA.pdf",
            XLS_FILE = "XLSX_TEST_DATA.xlsx";

    // Parsers
    void parsePdfTest (InputStream pdfFile) throws Exception {
        PDF pdf = new PDF(pdfFile);
        assertThat(pdf.text).contains(
                "Информация по лицевым счетам"
        );
    }

    void parseXlsTest (InputStream xlsFile) throws Exception {
        XLS xls = new XLS(xlsFile);
        assertThat(xls.excel
                .getSheetAt(1)
                .getRow(2)
                .getCell(0)
                .getStringCellValue()).contains("WP042 Трубка тормозная");

    }

    void parseCsvTest (InputStream csvFile) throws Exception {
        try (CSVReader reader = new CSVReader(new InputStreamReader(csvFile));) {
            List<String[]> strA = reader.readAll();
            assertThat(strA.get(2)).contains(
                    "ремень генератора: 8200821813 renault",
                    "1100",
                    "использовано");
        }
    }
    // (!) Need to use OpenJDK 17+ (cause 1.8, 11 have dependency troubles)
    @Test
    void parseZipArchiveTest() throws Exception {
        ZipFile zf = new ZipFile("src/test/resources/files/files.zip");
        for (Enumeration<? extends ZipEntry> iter = zf.entries(); iter.hasMoreElements(); ) {
            ZipEntry entryFile = iter.nextElement();
            if (entryFile.getName().contains("pdf")) {
                assertThat(entryFile.getName()).isEqualTo(PDF_FILE);
                parsePdfTest(zf.getInputStream(entryFile));
            } else if (entryFile.getName().contains("xlsx")) {
                assertThat(entryFile.getName()).isEqualTo(XLS_FILE);
                parseXlsTest(zf.getInputStream(entryFile));
            } else if (entryFile.getName().contains("csv")) {
                assertThat(entryFile.getName()).isEqualTo(CSV_FILE);
                parseCsvTest(zf.getInputStream(entryFile));
            }
        }
    }


}
