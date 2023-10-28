package DB;

import entity.Discipline;
import entity.DisciplineMark;
import entity.Student;
import entity.Term;

import java.util.List;

public interface  IDbManager {
    List<Student> getActiveStudent() throws ClassNotFoundException;

    List<Discipline> getActiveDiscipline() throws ClassNotFoundException;



    void createStudent(String ser_name, String name, String group, String date_in);

    void createDiscipline(String name);

    void deleteStudent(String ids);

    Student getStudentToId(String id);


    void modifyStudent(String id, String ser_name, String name, String group, String date_in);

    List<Term> getActiveTermStudent(String id);


    List<Term> getActiveTerms() throws ClassNotFoundException;

    List<DisciplineMark> getDisciplineMarkToTerm(Term term, Student st);

    Discipline getDisciplineToId(String id);

    void modifyDiscipline(String id, String name);

    Student getStudentTOId(String id);

    void deleteDiscipline(String ids);

    void createTerm(String name, String duration, String[] id);


    boolean checkUser(String login, String password);

    void deleteTerm(String selectId);

    List <Discipline> getDisciplineToTerm(String id);

    void modifyTerm(String id, String duration, String[] ids);
}
