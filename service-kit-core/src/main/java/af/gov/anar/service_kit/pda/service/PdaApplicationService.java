package af.gov.anar.service_kit.pda.service;

import af.gov.anar.service_kit.util.FileUploadService;
import af.gov.anar.service_kit.pda.model.PdaApplication;
import af.gov.anar.service_kit.pda.repository.PdaApplicationRepository;
import af.gov.anar.service_kit.util.HijriDateUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    public Map<String, Object> save(String onlineFormFamilyNo, String familyNo, MultipartFile file) throws IOException {

        String uploadPath = this.fileUploadDirectory.concat(HijriDateUtility.getCurrentJalaliDateAsString());
        Map<String, Object>  response = new HashMap<>();

        PdaApplication nidFamilyForm = new PdaApplication();
        nidFamilyForm.setNidFamilyNo(familyNo);
        nidFamilyForm.setOnlineFormFamilyNo(familyNo);
        nidFamilyForm.setDocOriginalName(file.getOriginalFilename());



        if(file == null){
            throw new RuntimeException("File Not Exist Exception");
        }

        String fileUrl = fileUploadService.saveAttachment(file, uploadPath);
        if (Objects.nonNull(fileUrl)) {
                nidFamilyForm.setDocPath(fileUrl);
        }

//        File tmpFile =new File(fileUrl);
//        int pageNo = getNumberOfPdfPages(tmpFile);
//        nidFamilyForm.setDocNumOfPages(pageNo);
//        tmpFile.();

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

    public int  getNumberOfPdfPages(File file) throws IOException {
        PDDocument document = new PDDocument();
        document.save(file);
        return document.getNumberOfPages();
    }

    public Map<String, Object> getListOfUnVerifiedDocs(String vertificationType, String centerCode) {
        Map<String, Object> response = new HashMap<>();

        if(vertificationType.equalsIgnoreCase("CENTER")){
// <<<<<<< issues_fix_branch
//             response.put("data", nidFamilyFormRepository.findByVerifiedAndNidFamilyNoStartsWith(false, centerCode));
// //            response.put("data", nidFamilyFormRepository.findNidFamilyNoContaining(centerCode));
// =======
            response.put("data", nidFamilyFormRepository.findByVerifiedAndRejectedAndNidFamilyNoStartsWith(false,false, centerCode));
// >>>>>>> main
        }else{
            response.put("data", nidFamilyFormRepository.findByVerifiedAndRejected(false,false));
        }

        response.put("status", HttpStatus.OK);
        return response;
    }

    public Map<String, Object> verify(String id) {
        Map<String, Object> response = new HashMap<>();

        PdaApplication pdaApplication= nidFamilyFormRepository.findById(id).orElse(null);

        if(pdaApplication == null)
            throw new RuntimeException("No Application Found Exception");

        pdaApplication.setVerified(true);
        nidFamilyFormRepository.save(pdaApplication);

        response.put("status", HttpStatus.OK);
        response.put("data", id);
        return response;
    }
}
