package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.Melodie_OrchestrantDAO;
import proiectOpera.model.Melodie_Orchestrant;

import java.util.List;

@Controller
public class Melodie_OrchestrantController {

    @Autowired
    private Melodie_OrchestrantDAO dao;

    @RequestMapping("/melodie_orchestrant")
    public String viewHomePage(Model model) {
        List<Melodie_Orchestrant> listaMuzicanti = dao.list();
        model.addAttribute("listaMuzicanti", listaMuzicanti);
        return "melodie_orchestrant/show";
    }

    @RequestMapping("/melodie_orchestrant/new")
    public String showNewForm(Model model) {
        Melodie_Orchestrant mel_om = new Melodie_Orchestrant();
        model.addAttribute("mel_om", mel_om);

        return "melodie_orchestrant/new_form";
    }

    @RequestMapping(value = "/melodie_orchestrant/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Melodie_Orchestrant") Melodie_Orchestrant mel_om) {
        dao.save(mel_om);

        return "redirect:/melodie_orchestrant";
    }

    @RequestMapping("/melodie_orchestrant/edit/{id_melodie}/{id_orchestrant}")
    public ModelAndView showEditForm(@PathVariable(name = "id_melodie") int id_melodie, @PathVariable(name = "id_orchestrant") int id_orchestrant) {
        ModelAndView mav = new ModelAndView("melodie_orchestrant/edit_form");
        Melodie_Orchestrant mel_om = dao.get(id_melodie,id_orchestrant);
        mav.addObject("mel_om", mel_om);

        return mav;
    }

    @RequestMapping(value = "/melodie_orchestrant/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Melodie_Orchestrant") Melodie_Orchestrant mel_om) {
        dao.update(mel_om);

        return "redirect:/melodie_orchestrant";
    }

    @RequestMapping("/melodie_orchestrant/delete/{id_melodie}/{id_orchestrant}")
    public String delete(@PathVariable(name = "id_melodie") int id_melodie, @PathVariable(name = "id_orchestrant") int id_orchestrant) {
        dao.delete(id_melodie,id_orchestrant);
        return "redirect:/melodie_orchestrant";
    }
}
