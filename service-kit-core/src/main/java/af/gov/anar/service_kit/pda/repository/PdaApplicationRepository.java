package af.gov.anar.service_kit.pda.repository;

import af.gov.anar.service_kit.pda.model.PdaApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PdaApplicationRepository extends JpaRepository<PdaApplication, String> {

    PdaApplication findByNidFamilyNo(String familyNo);
    List<PdaApplication> findByVerifiedAndRejected(boolean verified, boolean rejected);
    List<PdaApplication> findByVerifiedAndRejectedAndNidFamilyNoStartsWith(boolean verified,boolean rejected, String nidFamilyNo);
}
