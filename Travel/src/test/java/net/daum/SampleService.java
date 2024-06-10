package net.daum;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public int multiply(int a, int b) {
        return a * b;
    }
}