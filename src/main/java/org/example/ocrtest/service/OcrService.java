package org.example.ocrtest.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.example.ocrtest.model.OcrResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class OcrService {
    private final Tesseract tesseract;

    public OcrService(Tesseract tesseract) {
        this.tesseract = tesseract;
    }

    public OcrResult ocr(MultipartFile file) throws IOException, TesseractException {
        File convFile = convert((file));
        tesseract.setLanguage("ces");
        String text = tesseract.doOCR(convFile);
        return new OcrResult().setResult(text);
    }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
