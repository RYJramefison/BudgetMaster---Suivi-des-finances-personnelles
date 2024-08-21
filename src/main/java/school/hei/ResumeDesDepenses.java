package school.hei;

import lombok.Getter;

import java.util.List;

@Getter

public class ResumeDesDepenses {

    public void getTopCategories(Utilisateur user){
        List<Depense> Top3Depense= user.getListDesDepenses().stream().sorted((d1, d2) -> Double.compare(d1.getMontant(),d2.getMontant())).limit(3).toList();
        Top3Depense.forEach((depense -> System.out.println(depense)));
    };

    public void CalculateAverageSpendingPerCategory(){

    }
}
