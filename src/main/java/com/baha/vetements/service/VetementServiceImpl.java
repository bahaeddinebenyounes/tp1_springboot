package com.baha.vetements.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baha.vetements.dto.VetementDTO;
import com.baha.vetements.entities.Type;
import com.baha.vetements.entities.Vetement;
import com.baha.vetements.repos.VetementRepository;

@Service
public class VetementServiceImpl implements VetementService {
	
	@Autowired
	VetementRepository vetementRepository;
	
	@Autowired
	ModelMapper modelMapper;


	@Override
	public VetementDTO saveVetement(VetementDTO p) {
		return convertEntityToDto(vetementRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public VetementDTO updateVetement(VetementDTO p) {
		return convertEntityToDto(vetementRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public void deleteVetement(Vetement p) {
		// TODO Auto-generated method stub
		vetementRepository.delete(p);
		
	}

	@Override
	public void deleteVetementById(Long id) {
		// TODO Auto-generated method stub
		vetementRepository.deleteById(id);
	}

	@Override
	public VetementDTO getVetement(Long id) {
		// TODO Auto-generated method stub
		return convertEntityToDto(vetementRepository.findById(id).get());
	}

	@Override
	public List<VetementDTO> getAllVetements() {
		// TODO Auto-generated method stub
		return vetementRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Vetement> findByNomVetement(String nom) {
		// TODO Auto-generated method stub
		return vetementRepository.findByNomVetement(nom);
	}

	@Override
	public List<Vetement> findByNomVetementContains(String nom) {
		// TODO Auto-generated method stub
		return vetementRepository.findByNomVetementContains(nom);
	}

	@Override
	public List<Vetement> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return vetementRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Vetement> findByType(Type type) {
		// TODO Auto-generated method stub
		return vetementRepository.findByType(type);
	}
	
	
	@Override
	public List<Vetement> findByTypeIdType(Long id) {
		// TODO Auto-generated method stub
		return vetementRepository.findByTypeIdType(id);
	}



	@Override
	public List<Vetement> findByOrderByNomVetementAsc() {
		// TODO Auto-generated method stub
		return vetementRepository.findByOrderByNomVetementAsc();
	}

	@Override
	public List<Vetement> trierVetementsNomsPrix() {
		// TODO Auto-generated method stub
		return vetementRepository.trierVetementsNomsPrix();
	}

	@Override
	public VetementDTO convertEntityToDto(Vetement vetement) {
		// TODO Auto-generated method stub
		/**VetementDTO vetementDTO = new VetementDTO();
		 vetementDTO.setIdVetemnt(vetement.getIdVetemnt());
		 vetementDTO.setNomVetement(vetement.getNomVetement());
		 vetementDTO.setPrixVetement(vetement.getPrixVetement());
		 vetementDTO.setDateVetement(vetement.getDateVetement());
		 vetementDTO.setType(vetement.getType()); */
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		 VetementDTO vetementDTO = modelMapper.map(vetement, VetementDTO.class);

		 return vetementDTO; 
	}

	@Override
	public Vetement convertDtoToEntity(VetementDTO vetementDto) {
		/*Vetement vetement = new Vetement();
		vetement1.setIdVetemnt(vetement1.getIdVetemnt());
		vetement1.setNomVetement(vetement1.getNomVetement());
		vetement1.setPrixVetement(vetement1.getPrixVetement());
		vetement1.setDateVetement(vetement1.getDateVetement());
		vetement1.setType(vetement1.getType()); 
		 return vetement; */
		Vetement vetement = new Vetement();
		vetement = modelMapper.map(vetementDto, Vetement.class);
			return vetement;
		
		
		
		}

	


	
}
