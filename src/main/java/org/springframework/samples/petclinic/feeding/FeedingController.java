package org.springframework.samples.petclinic.feeding;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FeedingController {
 
	@Autowired
	FeedingService feedingService;
	@Autowired
	PetService petService;
	
	@GetMapping(value="/feeding/create")
	public String initCreationForm(ModelMap modelMap) {
		String vista = "feedings/createOrUpdateFeedingForm";
		Feeding feeding = new Feeding();
		List<FeedingType> feedingTypes = feedingService.getAllFeedingTypes();
		List<Pet> pets = petService.getAllPets();
		modelMap.addAttribute("feeding", feeding);
		modelMap.addAttribute("feedingTypes", feedingTypes);
		modelMap.addAttribute("pets", pets);
		return vista;
	}
	
	/*@PostMapping(value="/feeding/create")
	public String processCreationForm(@Valid Feeding feeding, BindingResult result) throws UnfeasibleFeedingException {
		if (result.hasErrors()) {
			return "feedings/createOrUpdateFeedingForm";
		} else {
			feedingService.save(feeding);
			return "redirect:welcome";
		}
	}*/
	
}
