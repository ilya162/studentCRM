package entity;

import java.util.Date;
import java.util.Objects;

public class Student {
    private int id;
    private String ser_name;
    private String name;
    private String group;
    private Date date_in;
    private byte status;

    public Student() {
    }

    public Student(int id, String ser_name, String name, String group, Date date_in, byte status) {
        this.id = id;
        this.ser_name = ser_name;
        this.name = name;
        this.group = group;
        this.date_in = date_in;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSer_name() {
        return ser_name;
    }

    public void setSer_name(String ser_name) {
        this.ser_name = ser_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && status == student.status && Objects.equals(ser_name, student.ser_name) && Objects.equals(name, student.name) && Objects.equals(group, student.group) && Objects.equals(date_in, student.date_in);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ser_name, name, group, date_in, status);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ser_name='" + ser_name + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", date_in=" + date_in +
                ", status=" + status +
                '}';
    }
}
