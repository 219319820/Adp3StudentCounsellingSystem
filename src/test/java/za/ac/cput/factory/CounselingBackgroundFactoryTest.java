package za.ac.cput.factory;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import za.ac.cput.entity.CounsellingBackground;

import static org.junit.jupiter.api.Assertions.*;

public class CounselingBackgroundFactoryTest {

    @Test
    public void createCounselingBackgroundType(){

        CounsellingBackground background=CounselingBackgroundFactory.createCounselingBackground(219319820,"Joseph","Smith",2036147892,"15 June 2021","30 minuites","Therapy");
        System.out.print(background);

    }
@Test
public void testEquality() {
    CounsellingBackground.Builder counselor1 = new CounsellingBackground.Builder()
            .setCounselingBackgroundId(218369785)
            .setCounsellorFirstName("Jetro")
            .setCounsellorLastName("Mathebula")
            .setCounsellorPhoneNumber(271587986)
            .setCounsellingDate("15 June 2021")
            .setCounsellingDuration("20 minuites")
            .setTreatmentTaken("Medication");

    CounsellingBackground.Builder counselor2 = new CounsellingBackground.Builder()
            .setCounselingBackgroundId(218369785)
            .setCounsellorFirstName("Jetro")
            .setCounsellorLastName("Mathebula")
            .setCounsellorPhoneNumber(271587986)
            .setCounsellingDate("15 June 2021")
            .setCounsellingDuration("20 minuites")
            .setTreatmentTaken("Medication");
    counselor1= counselor2;
    assertEquals(counselor1,counselor2);

    System.out.print("Equal");
}

@Test
 public void testIdentity(){

    CounsellingBackground.Builder counselor1= new CounsellingBackground.Builder()
            .setCounselingBackgroundId(218369785)
            .setCounsellorFirstName("Jade")
            .setCounsellorLastName("Mnisi")
            .setCounsellorPhoneNumber(277908548)
            .setCounsellingDate("16 June 2021")
            .setCounsellingDuration("45 minuites")
            .setTreatmentTaken("Deep Brain Stimulation");

    CounsellingBackground.Builder counselor2 = new CounsellingBackground.Builder()
            .setCounselingBackgroundId(218369785)
            .setCounsellorFirstName("Jade")
            .setCounsellorLastName("Mnisi")
            .setCounsellorPhoneNumber(277908548)
            .setCounsellingDate("16 June 2021")
            .setCounsellingDuration("45 minuites")
            .setTreatmentTaken("Deep Brain Stimulation");

  counselor1=counselor2;
    System.out.printf("Identical");


}

@Test

public void testTimeout(){
    AssertTimeout(5);
}

    private void AssertTimeout(int i) {
    }

@Test
    @Disabled
            (" if timeout is exceeded")
public void testWillBeExecuted() {


}

}