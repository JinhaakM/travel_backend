package net.daum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void testMultiply() {
        int result = sampleService.multiply(234234234, 23423423);
        Assertions.assertEquals(12, result);
    }
}
