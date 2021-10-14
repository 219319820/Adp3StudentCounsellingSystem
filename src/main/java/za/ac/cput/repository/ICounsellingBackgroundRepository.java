package za.ac.cput.repository;

import za.ac.cput.entity.CounsellingBackground;

import java.util.Set;

public interface ICounsellingBackgroundRepository extends IRepository<CounsellingBackground, String> {
    public Set<CounsellingBackground> getAll();
}
