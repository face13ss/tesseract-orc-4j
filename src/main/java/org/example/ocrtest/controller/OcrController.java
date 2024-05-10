package org.example.ocrtest.controller;

import net.sourceforge.tess4j.OCRResult;
import net.sourceforge.tess4j.TesseractException;
import org.example.ocrtest.model.OcrResult;
import org.example.ocrtest.service.OcrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/ocr")
public class OcrController {
    private final OcrService ocrService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OcrController.class);

    public OcrController(OcrService ocrService) {
        this.ocrService = ocrService;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/getting")
    public ResponseEntity ok(@RequestParam("language") String language){
        LOGGER.info(language);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/processDocument")
    public ResponseEntity<OcrResult> upload(@RequestParam("file")MultipartFile file
                                            ) throws IOException, TesseractException {
        return ResponseEntity.ok(ocrService.ocr(file));
    }
}
