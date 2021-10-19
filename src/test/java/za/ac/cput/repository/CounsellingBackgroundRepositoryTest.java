package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.CounsellingBackground;
import za.ac.cput.factory.CounselingBackgroundFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CounsellingBackgroundRepositoryTest {

    private static CounsellingBackgroundRepository repository= CounsellingBackgroundRepository.getCounsellingBackgroundRepository();

    private static CounsellingBackground background= CounselingBackgroundFactory.createCounselingBackground(
            219319820,
            "Joseph",
            "Tom",
            794446623,
            "29 August 2021",
            "45 Minutes",
            "Medication");


    @Test
    void a_create() {

        CounsellingBackground created=repository.create(background);
        assertEquals(created.getCounselingBackgroundId,background.getCounselingBackgroundId);
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
       CounsellingBackground read=repository.read(background.getCounselingBackgroundId);
       assertNotNull(read);
        System.out.println("Read " +read);

    }

    @Test
    void c_update() {

        CounsellingBackground updated=new CounsellingBackground.Builder().copy(background).setCounsellorFirstName("Jetro").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated" + updated);
    }

    @Test
    void e_delete() {

        boolean success=repository.delete(background.getCounselingBackgroundId);
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}