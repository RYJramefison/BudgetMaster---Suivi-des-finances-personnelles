package school.hei;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public class Depense {
    private String description;
    private double montant;
    private CategoriesDeDepenses categorie;
    private LocalDate date;
}
