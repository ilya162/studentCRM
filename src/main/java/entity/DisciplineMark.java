package entity;

import java.util.Objects;

public class DisciplineMark {
    private int idD;
    private String nameD;
    private int idM;
    private String nameM;

    public DisciplineMark() {
    }

    public DisciplineMark(int idB, String nameD, int idM, String nameM) {
        this.idD = idD;
        this.nameD = nameD;
        this.idM = idM;
        this.nameM = nameM;
    }

    public int idD() {
        return idD;
    }

    public void setidD(int idD) {
        this.idD = idD;
    }

    public String getNameD() {
        return nameD;
    }

    public void setNameD(String nameD) {
        this.nameD = nameD;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineMark that = (DisciplineMark) o;
        return idD == that.idD && idM == that.idM && Objects.equals(nameD, that.nameD) && Objects.equals(nameM, that.nameM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idD, nameD, idM, nameM);
    }

    @Override
    public String toString() {
        return "DisciplineMark{" +
                "idD=" + idD +
                ", nameD='" + nameD + '\'' +
                ", idM=" + idM +
                ", nameM='" + nameM + '\'' +
                '}';
    }
}

