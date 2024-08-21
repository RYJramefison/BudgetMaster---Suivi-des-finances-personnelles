package school.hei;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class Utilisateur {
    private String nom;
    private int budgetMensuel;
    private List<Depense> listDesDepenses;

    public boolean addExpense(Depense depense){
        return listDesDepenses.add(depense);
    }

    public void getExpenseByCategory(CategoriesDeDepenses categorie){
        List<Depense> lesDepenses = new ArrayList<>();
        for (Depense depense : listDesDepenses) {
            if (depense.getCategorie().equals(categorie)){
                lesDepenses.add(depense);
            }
        }

        lesDepenses.forEach((depense -> System.out.println(depense)));
    }

    public double getTotalSpentThisMonth(){
        LocalDate dateActuel = LocalDate.now();

        List<Depense> depenseActuel= listDesDepenses.stream().filter((depense -> !depense.getDate().isBefore(dateActuel))).toList();

        double montantTotal = 0;

        for (Depense depense : depenseActuel) {
            montantTotal += depense.getMontant();
        }

        return montantTotal;
    }

    public double getRemainingBudget(){
        LocalDate dateActuel = LocalDate.now();

        List<Depense> depenseActuel = listDesDepenses.stream().filter((depense -> !depense.getDate().isBefore(dateActuel))).toList();

        double montantTotal = 0;

        for (Depense depense : depenseActuel) {
            montantTotal += depense.getMontant();
        }

        return budgetMensuel - montantTotal;
    }


    public void getTopCategories(Utilisateur user){
        List<Depense> Top3Depense= user.getListDesDepenses().stream().sorted((d1, d2) -> Double.compare(d1.getMontant(),d2.getMontant())).limit(3).toList();
        Top3Depense.forEach((depense -> System.out.println(depense)));
    };

}
