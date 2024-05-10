package org.example.ocrtest;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OcrTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OcrTestApplication.class, args);
    }

    @Bean
    Tesseract getTesseract(){
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("./tessdata");
        return tesseract;
    }

}
