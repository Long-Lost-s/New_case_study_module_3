package DAO;

import model.Classes;

import java.util.List;

public interface IClassesDAO {
    public List<Classes> selectAllClasses();
    public void insertClasses(Classes classes);
    public void updateClasses(Classes classes);
    public void deleteClasses(Classes classes);
    public Classes selectClasses(int id);
}
