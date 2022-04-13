package ma.enset.springmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.springmvc.entites.Patient;
import ma.enset.springmvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping(path = "/user/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "10") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        Page<Patient> patients = patientRepository.findByNomContains(keyword,PageRequest.of(page, size));

        model.addAttribute("patientsList", patients.getContent());
        model.addAttribute("pages", new int[patients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "patients";
    }



    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }


    //if we are not going to use thymleaf
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> ListPatients() {
        return patientRepository.findAll();
    }


    @GetMapping("/admin/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/admin/save")
    public String savePatient(Patient patient, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            patientRepository.save(patient);
        }
        return "redirect:/user/index";

    }

    @GetMapping("/admin/editPatient")
    public String editPatient(Model model,@RequestParam long id,@RequestParam int page,@RequestParam String keyword) {
        Patient patient = patientRepository.findById(id).orElse(null);
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editPatient";

    }

    @GetMapping("/admin/delete")
    public String delete(Long id,int page,String keyword){
        patientRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }



}
