package ru.kds.tests.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.kds.tests.files.lecture.domain.Student;

import java.nio.file.Paths;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

public class JacksonJsonHWTest {
    @Test
    // (!) Run test with gradle JVM 11 version
    void jacksonJsonTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(Paths.get("src/test/resources/files/student.json").toFile(), Student.class);
        assertThat(student.firstName).isEqualTo("Anton");
        assertThat(student.lastName).isEqualTo("Gorodetskiy");
        assertThat(student.userEmail).isEqualTo("Anton.Gorodetskiy@mail.com");
        assertThat(student.gender).isEqualTo("Male");
        assertThat(student.userNumber).isEqualTo("9296112233");
    }

}
