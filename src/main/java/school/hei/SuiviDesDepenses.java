package school.hei;

import lombok.Getter;

import java.time.LocalDate;



public interface SuiviDesDepenses {

    public boolean AjouterDepense(String description, int montant, CategoriesDeDepenses categorie, LocalDate date);

    public void AfficherLesDepenses(LocalDate date);

    public void AfficherLesDepensesParCategories(CategoriesDeDepenses categorie);

}
