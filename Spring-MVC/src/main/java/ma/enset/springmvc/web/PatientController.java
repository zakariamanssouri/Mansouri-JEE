package ma.enset.springmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.springmvc.entites.Patient;
import ma.enset.springmvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping(path = "/index")
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

    @GetMapping("/delete")
    public String delete(Long id,int page,String keyword){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }


    //if we are not going to use thymleaf
    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> ListPatients() {
        return patientRepository.findAll();
    }





}
