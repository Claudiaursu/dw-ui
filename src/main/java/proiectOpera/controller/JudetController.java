package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.JudetDAO;
import proiectOpera.model.Judet;

import java.util.List;

@Controller
public class JudetController {

    @Autowired
    private JudetDAO judetDAO;

    @RequestMapping("/judete")
    public String viewAllJudete(Model model) {
        List<Judet> listJudete = judetDAO.list();
        model.addAttribute("listJudete", listJudete);
        return "judete/show";
    }

    @RequestMapping("/judete/new")
    public String showNewJudetForm(Model model) {
        Judet judet = new Judet();
        model.addAttribute("judet", judet);
        return "judete/new_form";
    }

    @RequestMapping(value = "/judete/save", method = RequestMethod.POST)
    public String saveJudet(@ModelAttribute("judet") Judet judet) {
        judetDAO.save(judet);
        return "redirect:/judete";
    }

    @RequestMapping("/judete/edit/{id_judet}")
    public ModelAndView showEditJudetForm(@PathVariable(name = "id_judet") int id_judet) {
        ModelAndView mav = new ModelAndView("judete/edit_form");
        Judet judet = judetDAO.get(id_judet);
        mav.addObject("judet", judet);
        return mav;
    }

    @RequestMapping(value = "/judete/update", method = RequestMethod.POST)
    public String updateJudet(@ModelAttribute("judet") Judet judet) {
        judetDAO.update(judet);
        return "redirect:/judete";
    }

    @RequestMapping("/judete/delete/{id_judet}")
    public String deleteJudet(@PathVariable(name = "id_judet") int id_judet) {
        judetDAO.delete(id_judet);
        return "redirect:/judete";
    }
}
