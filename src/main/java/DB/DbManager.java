package DB;

import entity.Discipline;
import entity.DisciplineMark;
import entity.Student;
import entity.Term;
import сonstaince.BdVariables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbManager implements IDbManager {
    @Override
    public List<Student> getActiveStudent() {
        List<Student> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM  student where status = '1';");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSer_name(rs.getString("ser_name"));
                student.setGroup(rs.getString("group"));
                student.setDate_in(rs.getDate("date_in"));
                student.setStatus((byte) 1);
                res.add(student);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Discipline> getActiveDiscipline() {
        List<Discipline> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM discipline where status = '1';");
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setName(rs.getString("name"));
                discipline.setStatus((byte) 1);
                res.add(discipline);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<Term> getActiveTerms() {
        List<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM term where status = '1';");
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName(rs.getString("name"));
                term.setDuration(rs.getString("duration"));
                term.setStatus((byte) 1);
                res.add(term);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<DisciplineMark> getDisciplineMarkToTerm(Term term, Student st) {
        List<DisciplineMark> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select d.id as id_d, d.name as name_d,m.id as id_m, m.name as name_m from student s\n" +
                    "join student_term_discipline std on s.id = std.student_id\n" +
                    "join term_discipline td on td.id= std.term_discipline_id\n" +
                    "join term t on t.id = td.term_id\n" +
                    "join discipline d  on d.id = td.discipline_id\n" +
                    " left join student_term_discipline_mark stdm on stdm.student_id = s.id and stdm.term_discipline_id = td.id\n" +
                    " left join mark m on stdm.mark_id=m.id\n" +
                    " where s.id = " + st.getId() + " and t.id=" + term.getId());
            while (rs.next()) {
                DisciplineMark dm = new DisciplineMark();
                dm.setidD(rs.getInt("id_d"));
                dm.setNameD(rs.getString("name_d"));
                dm.setIdM(rs.getInt("id_m"));
                dm.setNameM(rs.getString("name_m"));
                res.add(dm);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Discipline getDisciplineToId(String id) {
        Discipline res = new Discipline();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM  discipline where id =" + id + ";");
            while (rs.next()) {
                res.setId(rs.getInt("id"));
                res.setName(rs.getString("name"));
                res.setStatus((byte) 1);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void modifyDiscipline(String id, String name) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("UPDATE `discipline` SET `name` = '" + name + "' WHERE (`id` = " + id + ");");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudentTOId(String id) {
        Student res = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM  student where id =" + id + ";");
            while (rs.next()) {
                res.setId(rs.getInt("id"));
                res.setName(rs.getString("name"));
                res.setSer_name(rs.getString("ser_name"));
                res.setGroup(rs.getString("group"));
                res.setDate_in(rs.getDate("date_in"));
                res.setStatus((byte) 1);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void deleteDiscipline(String ids) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` in(" + ids + ") );");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createTerm(String name, String duration, String[] id) {
        List<Term> res = new ArrayList<>();
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            String createTerm = "INSERT INTO `term` (`name`, `duration`) VALUES ('" + name + "','" + duration + "')  ";

            Statement statement = conn.createStatement();
            stmt.executeUpdate(createTerm, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            int lastKey = 1;
            while (keys.next()) {
                lastKey = keys.getInt(1);
            }
            System.out.println("Last Key: " + lastKey);
            for (String s : id) {

                stmt.execute("INSERT INTO `term_discipline` (`term_id`, `discipline_id`) VALUES ('" + lastKey + "','" + s + "');");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean checkUser(String login, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM user where login = '" + login + "' and password = '" + password + "'");
            while (rs.next()) {
                return true;


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void deleteTerm(String selectId) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("UPDATE `term` SET `status` = '0' WHERE `id` =  '" + selectId + "'");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Discipline> getDisciplineToTerm(String id) {
        List<Discipline> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT d.id as id_d,d.name as name_d from term_discipline td\n" +
                    "            join discipline d on td.discipline_id= d.id\n" +
                    "            join term t on td.term_id = t.id\n" +
                    "            where t.id =  '" + id + "'");

            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id_d"));
                discipline.setName(rs.getString("name_d"));
                res.add(discipline);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void modifyTerm(String id, String duration, String[] ids) {
        List<Term> res = new ArrayList<>();
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("UPDATE `term` SET `duration` = '" + duration + "' WHERE (`id` = '" + id + "')");

            Statement statement = conn.createStatement();


            for (String s : ids) {

                stmt.execute("UPDATE `term_discipline` SET `discipline_id` = NULL WHERE term_id = '" + id + "' and discipline_id ='" + s + "'");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override

    public void createStudent(String ser_name, String name, String group, String date_in) {
        List<Student> res = new ArrayList<>();
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("INSERT INTO `java_7_student`.`student` (`ser_name`, `name`, `group`, `date_in`)" + " VALUES ('" + ser_name + "','" + name + "','" + group + "','" + date_in + "')");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createDiscipline(String name) {
        List<Discipline> res = new ArrayList<>();
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("INSERT INTO `java_7_student`.`discipline`(`name`)" + " VALUES ('" + name + "')");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(String ids) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` in(" + ids + ") );");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Student getStudentToId(String id) {
        Student res = new Student();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM  student where id =" + id + ";");
            while (rs.next()) {

                res.setId(rs.getInt("id"));
                res.setName(rs.getString("name"));
                res.setSer_name(rs.getString("ser_name"));
                res.setGroup(rs.getString("group"));
                res.setDate_in(rs.getDate("date_in"));
                res.setStatus((byte) 1);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void modifyStudent(String id, String ser_name, String name, String group, String date_in) {
        Connection conn;
        Statement stmt;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            stmt = conn.createStatement();

            stmt.execute("UPDATE `student` SET `ser_name` = '" + ser_name + "', `name` = '" + name + "', `group` = '" + group + "', `date_in` = '" + date_in + "' WHERE (`id` = " + id + ");");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Term> getActiveTermStudent(String id) {
        List<Term> res = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_7_student", BdVariables.LOGIN, BdVariables.PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT t.* FROM term t\n" +
                    "                    join term_discipline td on t.id = td.discipline_id\n" +
                    "                    join student_term_discipline std on std.term_discipline_id = td.id\n" +
                    "                   where std.student_id='" + id + "' and t.status = '1' order by t.name;");
            while (rs.next()) {
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setName(rs.getString("name"));
                term.setDuration(rs.getString("status"));
                term.setStatus((byte) 1);
                res.add(term);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


}





