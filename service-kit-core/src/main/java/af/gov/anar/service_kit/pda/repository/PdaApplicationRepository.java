package af.gov.anar.service_kit.pda.repository;

import af.gov.anar.service_kit.pda.model.PdaApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PdaApplicationRepository extends JpaRepository<PdaApplication, String> {

    PdaApplication findByNidFamilyNo(String familyNo);
    List<PdaApplication> findByVerified(boolean verified);
    List<PdaApplication> findByVerifiedAndNidFamilyNoStartsWith(boolean verified, String nidFamilyNo);

//    @Query(value = "SELECT fn FROM nid_pda_application fn WHERE fn.nid_family_no LIKE %-:centerCode-%", nativeQuery = true)
//    List<PdaApplication> findNidFamilyNoContaining(@Param("centerCode") String centerCode);
  
    List<PdaApplication> findByVerifiedAndRejected(boolean verified, boolean rejected);
    List<PdaApplication> findByVerifiedAndRejectedAndNidFamilyNoStartsWith(boolean verified,boolean rejected, String nidFamilyNo);
}
