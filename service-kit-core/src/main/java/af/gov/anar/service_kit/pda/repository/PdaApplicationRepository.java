package af.gov.anar.service_kit.pda.repository;

import af.gov.anar.service_kit.pda.model.PdaApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PdaApplicationRepository extends JpaRepository<PdaApplication, String> {

    PdaApplication findByNidFamilyNo(String familyNo);
}
