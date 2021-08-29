package za.ac.cput.Service;

import za.ac.cput.entity.CounsellingBackground;

import java.util.Set;

public interface ICounselingBackgroundService extends IService<CounsellingBackground,String> {

Set<CounsellingBackground> getAll();
}
