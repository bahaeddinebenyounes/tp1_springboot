package com.baha.vetements.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.baha.vetements.entities.Type;
import com.baha.vetements.entities.Vetement;


@RepositoryRestResource(path = "rest")
public interface VetementRepository extends JpaRepository<Vetement, Long> {

	List<Vetement> findByNomVetement(String nom);
	List<Vetement> findByNomVetementContains(String nom); 
	
	@Query("select p from Vetement p where p.nomVetement like %?1 and p.prixVetement > ?2")
    List<Vetement> findByNomPrix (String nom, Double prix);
	
    @Query("select p from Vetement p where p.type = ?1")
    List<Vetement> findByType(Type type);
    
    @Query("select p from Vetement p order by p.nomVetement ASC, p.prixVetement DESC")
    List<Vetement> trierVetementsNomsPrix ();
    
    List<Vetement> findByOrderByNomVetementAsc();
	List<Vetement> findByTypeIdType(Long id);
}
