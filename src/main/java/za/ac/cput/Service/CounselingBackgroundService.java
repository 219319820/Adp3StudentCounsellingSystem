package za.ac.cput.Service;

import za.ac.cput.entity.CounsellingBackground;
import za.ac.cput.repository.CounsellingBackgroundRepository;

import java.util.Set;

public class CounselingBackgroundService implements ICounselingBackgroundService{
private static CounselingBackgroundService backgroundService=null;
private CounsellingBackgroundRepository backgroundRepository;

public CounselingBackgroundService(){this.backgroundRepository=CounsellingBackgroundRepository.getCounsellingBackgroundRepository();}

    public static CounselingBackgroundService getBackgroundService() {
        if (backgroundService == null) {
            backgroundService = new CounselingBackgroundService();
        }
        return backgroundService;
    }


    @Override
    public CounsellingBackground create(CounsellingBackground counsellingBackground) {
        return this.backgroundRepository.create(counsellingBackground);
    }

    @Override
    public CounsellingBackground read(String s) {
        return this.backgroundRepository.read(s);
    }

    @Override
    public CounsellingBackground update(CounsellingBackground counsellingBackground) {
        return this.backgroundRepository.update(counsellingBackground);
    }

    @Override
    public boolean delete(String s) {
        return this.backgroundRepository.delete(s);
    }

    @Override
    public Set<CounsellingBackground> getAll() {
        return this.backgroundRepository.getAll();
    }
}
