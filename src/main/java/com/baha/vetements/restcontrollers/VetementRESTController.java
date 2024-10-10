package com.baha.vetements.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baha.vetements.dto.VetementDTO;
import com.baha.vetements.entities.Vetement;
import com.baha.vetements.service.VetementService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class VetementRESTController {
	
	@Autowired
	VetementService vetementService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<VetementDTO> getAllVetements() {
		return vetementService.getAllVetements();
		} 

	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public VetementDTO geVetementById(@PathVariable("id") Long id) {
	return vetementService.getVetement(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public VetementDTO createVetement(@RequestBody VetementDTO vetementDTO) {
		return vetementService.saveVetement(vetementDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public VetementDTO updateVetement(@RequestBody VetementDTO vetementDTO) {
	return vetementService.updateVetement(vetementDTO);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVetement(@PathVariable("id") Long id)
	{
	vetementService.deleteVetementById(id);
	}

	@RequestMapping(value="/vetstype/{idType}",method = RequestMethod.GET)
	public List<Vetement> getVetementsByTypeId(@PathVariable("idType") Long idType) {
	return vetementService.findByTypeIdType(idType);
	}
	
	
	
}
