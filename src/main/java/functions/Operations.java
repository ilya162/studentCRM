package functions;

import entity.DisciplineMark;
import entity.Term;

import java.util.List;

public class Operations {
    public static double getAvarage(List<DisciplineMark> dm) {
        if (dm == null || dm.size() == 0) {
            return 0;
        }
        int summ = 0;
        for (DisciplineMark mark : dm) {
            summ = summ + Integer.parseInt(mark.getNameM());

        }
        return summ / dm.size();
    }

    public static Term getSelectTerm(String selectId, List<Term> terms) {
        int i = Integer.parseInt(selectId);
        for (Term term : terms) {
            if (term.getId() == i) {
                return term;
            }
        }
        return null;
    }
}
