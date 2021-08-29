package za.ac.cput.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.CounsellingBackground;
import za.ac.cput.factory.CounselingBackgroundFactory;
import za.ac.cput.repository.CounsellingBackgroundRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class CounselingBackgroundServiceTest {

    private static ICounselingBackgroundService service= CounselingBackgroundService.getBackgroundService();


    private static CounsellingBackground background= CounselingBackgroundFactory.createCounselingBackground(
            219319820,
            "Joseph",
            "Tom",
            794446623,
            "29 August 2021",
            "45 Minutes",
            "Medication");



    @Test
    void a_create(){
CounsellingBackground created =service.create(background);
assertEquals(background.getCounselingBackgroundId,created.getCounselingBackgroundId);
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read(){
        CounsellingBackground read=service.read(background.getCounselingBackgroundId);

        assertNotNull(read);
        System.out.println("Read:" +read);
    }

    @Test
    void c_update() {
        CounsellingBackground updated = new CounsellingBackground.Builder().copy(background).setCounsellingDate("30 October 2021").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }
    @Test
    void e_delete() {
        boolean _true = service.delete(background.getCounselingBackgroundId);
        assertTrue(_true);
        System.out.println("Delete: " + _true);
    }
    @Test
    void d_getAll() {
        System.out.println("Display All: \n" + service.getAll());
    }
}


