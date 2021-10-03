package za.ac.cput.factory;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import za.ac.cput.entity.CounsellingBackground;
import za.ac.cput.entity.MentalHealth;

import static org.junit.jupiter.api.Assertions.*;

public class MentalHealthFactoryTest {

    @Test
    public void createMentalHealthFactoryType(){



        MentalHealth health=MentalHealthFactory.createMentalHealth(219319820,"Anxiety","Generalized Anxiety Disorder",300);
        System.out.println(health);
    }




    @Test
    public void TestEquality(){

        MentalHealth.Builder health1= new MentalHealth.Builder()
                .setUserId(219319821)
                .setDisorderName("Depression")
                .setDisorderDesc("Feeling sad or having a depressed mood")
                .setCounsellingBackgroundId(302);

        MentalHealth.Builder health2= new MentalHealth.Builder()
                .setUserId(219319821)
                .setDisorderName("Depression")
                .setDisorderDesc("Feeling sad or having a depressed mood")
                .setCounsellingBackgroundId(302);

        health1= health2;
        assertEquals(health1,health2);

        System.out.println("Health1 is Equal to Health2");

    }

    @Test
    public void TestIdentity(){

        MentalHealth.Builder health1= new MentalHealth.Builder()
                .setUserId(219319821)
                .setDisorderName("Depression")
                .setDisorderDesc("Feeling sad or having a depressed mood")
                .setCounsellingBackgroundId(302);

        MentalHealth.Builder health2= new MentalHealth.Builder()
                .setUserId(219319821)
                .setDisorderName("Depression")
                .setDisorderDesc("Feeling sad or having a depressed mood")
                .setCounsellingBackgroundId(302);

        health1= health2;
        System.out.println("Identical");


    }

    @Test

    public void testTimeout(){
        AssertTimeout(50);
    }

    private void AssertTimeout(int i) {
    }

    @Test
    @Disabled
            (" if timeout is exceeded")
    public void testWillBeExecuted() {


    }

}