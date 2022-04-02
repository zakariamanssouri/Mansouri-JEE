package ma.enset.springmvc.web;

import lombok.AllArgsConstructor;
import ma.enset.springmvc.entites.Patient;
import ma.enset.springmvc.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private final PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patientsList", patients);
        return "patients";
    }


}
