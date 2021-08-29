package za.ac.cput.repository;

import za.ac.cput.entity.CounsellingBackground;

import java.util.HashSet;
import java.util.Set;

public class CounsellingBackgroundRepository implements ICounsellingBackgroundRepository{

private static CounsellingBackgroundRepository counsellingBackgroundRepository=null;

private Set<CounsellingBackground>  counsellingDB=null;

private CounsellingBackgroundRepository(){counsellingDB=new HashSet<CounsellingBackground>();}

public static  CounsellingBackgroundRepository getCounsellingBackgroundRepository(){
    if(counsellingBackgroundRepository==null){

        counsellingBackgroundRepository=new CounsellingBackgroundRepository();

    }


    return counsellingBackgroundRepository;
}





    @Override
    public CounsellingBackground create(CounsellingBackground counsellingBackground) {
    boolean success=counsellingDB.add(counsellingBackground);
    if(!success){

    return null;}
    return  counsellingBackground;
    }

    @Override
    public CounsellingBackground read(String counsellingID) {
    for(CounsellingBackground counsellingBackground:counsellingDB)
        if(counsellingBackground.getCounselingBackgroundId.equals(counsellingID)){

            return  counsellingBackground;
        }
        return null;
    }

    @Override
    public CounsellingBackground update(CounsellingBackground counsellingBackground) {
        CounsellingBackground background1=read(counsellingBackground.getCounselingBackgroundId);
    if(background1 !=null){
        counsellingDB.remove(background1);
        counsellingDB.add(counsellingBackground);
        return counsellingBackground;

    }
    return null;
    }

    @Override
    public boolean delete(String counsellingBackgroundID) {
    CounsellingBackground backgroundToDelete=read(counsellingBackgroundID);
    if (backgroundToDelete==null)
    {

        return false;
    }
    counsellingDB.remove(backgroundToDelete);
    return true;


    }

    @Override
    public Set<CounsellingBackground> getAll() {
        return counsellingDB;
    }
}
