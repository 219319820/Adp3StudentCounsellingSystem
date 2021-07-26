package za.ac.cput.factory;

/*Factory for MemtalHealth
Author :Justin Nkuna(219319820)
Date:11 June 2021
 */

import za.ac.cput.entity.MentalHealth;

public class MentalHealthFactory {

    public static MentalHealth build(int userId,String disorderName,String disorderDesc, int counsellingBackgroundId)
    {

        MentalHealth health = new MentalHealth.Builder()
                .setUserId(userId)
                .setDisorderName(disorderName)
                .setDisorderDesc(disorderDesc)
                .setCounsellingBackgroundId(counsellingBackgroundId).build();



        return health;
    }



}
