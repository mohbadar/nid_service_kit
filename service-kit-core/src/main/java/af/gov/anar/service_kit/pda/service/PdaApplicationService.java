package af.gov.anar.service_kit.pda.service;

import af.gov.anar.service_kit.util.FileUploadService;
import af.gov.anar.service_kit.pda.model.PdaApplication;
import af.gov.anar.service_kit.pda.repository.PdaApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PdaApplicationService {

    @Autowired
    private PdaApplicationRepository nidFamilyFormRepository;
    @Autowired
    private FileUploadService fileUploadService;


    @Value("${upload.pda.dir}")
    private String fileUploadDirectory;

    public Map<String, Object> save(String familyNo, MultipartFile file){

        Map<String, Object>  response = new HashMap<>();

        PdaApplication nidFamilyForm = new PdaApplication();
        nidFamilyForm.setNidFamilyNo(familyNo);

        if(file == null){
            throw new RuntimeException("File Not Exist Exception");
        }

        String fileUrl = fileUploadService.saveAttachment(file, fileUploadDirectory);
        if (Objects.nonNull(fileUrl)) {
                nidFamilyForm.setDocPath(fileUrl);
        }

        nidFamilyFormRepository.save(nidFamilyForm);

        response.put("status", HttpStatus.OK);
        return response;
    }

    public PdaApplication search(String familyNo){
        return nidFamilyFormRepository.findByNidFamilyNo(familyNo);
    }


    public Resource download(String uuid) throws IOException, InterruptedException, URISyntaxException {

        PdaApplication nidFamilyForm = nidFamilyFormRepository.findById(uuid).orElse(null);

        if(nidFamilyForm == null) return null;

        Path path = Paths.get(nidFamilyForm.getDocPath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return resource;
    }

}
