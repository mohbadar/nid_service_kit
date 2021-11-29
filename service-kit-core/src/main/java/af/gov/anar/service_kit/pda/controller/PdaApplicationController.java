package af.gov.anar.service_kit.pda.controller;

import af.gov.anar.service_kit.pda.model.PdaApplication;
import af.gov.anar.service_kit.pda.service.PdaApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/api/nid")
public class PdaApplicationController {

    @Autowired
    private PdaApplicationService nidFamilyFormService;

    @PostMapping(value = "/process-docs/store", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE })
    public ResponseEntity<Map<String, Object>> store(
            @RequestParam(name = "familyNo") String familyNo,
            @RequestParam(name = "file", required = false) MultipartFile file) {

        return ResponseEntity.ok(nidFamilyFormService.save(familyNo, file));

    }

    @PostMapping(value = "/process-docs/search", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
            MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE })
    public ResponseEntity<PdaApplication> registerOfflineConsumer(
            @RequestParam(name = "familyNo") String familyNo) {
        return ResponseEntity.ok(nidFamilyFormService.search(familyNo));

    }

    @PostMapping(value = "/process-docs/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadDocument(@RequestBody(required = true) String uuid)
            throws IOException, InterruptedException, URISyntaxException {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(nidFamilyFormService.download(uuid));
    }

}
