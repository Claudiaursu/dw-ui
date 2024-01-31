package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.LocalitateDAO;
import proiectOpera.model.Localitate;

import java.util.List;

@Controller
public class LocalitateController {

    @Autowired
    private LocalitateDAO localitateDAO;

    @RequestMapping("/localitati")
    public String viewAllLocalitati(Model model) {
        List<Localitate> listLocalitati = localitateDAO.list();
        model.addAttribute("listLocalitati", listLocalitati);
        return "localitati/show";
    }

    @RequestMapping("/localitati/new")
    public String showNewLocalitateForm(Model model) {
        Localitate localitate = new Localitate();
        model.addAttribute("localitate", localitate);
        return "localitati/new_form";
    }

    @RequestMapping(value = "/localitati/save", method = RequestMethod.POST)
    public String saveLocalitate(@ModelAttribute("localitate") Localitate localitate) {
        localitateDAO.save(localitate);
        return "redirect:/localitati";
    }

    @RequestMapping("/localitati/edit/{id_localitate}")
    public ModelAndView showEditLocalitateForm(@PathVariable(name = "id_localitate") int id_localitate) {
        ModelAndView mav = new ModelAndView("localitati/edit_form");
        Localitate localitate = localitateDAO.get(id_localitate);
        mav.addObject("localitate", localitate);
        return mav;
    }

    @RequestMapping(value = "/localitati/update", method = RequestMethod.POST)
    public String updateLocalitate(@ModelAttribute("localitate") Localitate localitate) {
        localitateDAO.update(localitate);
        return "redirect:/localitati";
    }

    @RequestMapping("/localitati/delete/{id_localitate}")
    public String deleteLocalitate(@PathVariable(name = "id_localitate") int id_localitate) {
        localitateDAO.delete(id_localitate);
        return "redirect:/localitati";
    }
}
