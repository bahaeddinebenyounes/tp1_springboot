package com.baha.vetements.service;

import java.util.List;

import com.baha.vetements.dto.VetementDTO;
import com.baha.vetements.entities.Type;
import com.baha.vetements.entities.Vetement;


public interface VetementService {
	VetementDTO saveVetement(VetementDTO p);
	VetementDTO updateVetement(VetementDTO p);
	void deleteVetement(Vetement p);
	void deleteVetementById(Long id);
	VetementDTO getVetement(Long id);
	List<VetementDTO> getAllVetements();
	List<Vetement> findByNomVetement(String nom);
	List<Vetement> findByNomVetementContains(String nom);
	List<Vetement> findByNomPrix (String nom, Double prix);
	List<Vetement> findByType (Type type);
	List<Vetement> findByTypeIdType(Long id);
	List<Vetement> findByOrderByNomVetementAsc();
	List<Vetement> trierVetementsNomsPrix();
	
	VetementDTO convertEntityToDto (Vetement vetement);
	
	Vetement convertDtoToEntity(VetementDTO vetementDto);



}
