package metier;

import java.util.List;

public interface IMetier<T> {
    void add(T o); // Ajouter un objet
    List<T> getAll(); // Retourner tous les objets
    T findById(long id); // Rechercher un objet par son id
    void delete(long id); // Supprimer un objet par son id
}
