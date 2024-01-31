package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.ActeDAO;
import proiectOpera.model.Acte;

import java.util.List;

@Controller
public class ActeController {

    @Autowired
    private ActeDAO acteDAO;

    @RequestMapping("/acte")
    public String viewActePage(Model model) {
        List<Acte> listActe = acteDAO.list();
        model.addAttribute("listActe", listActe);
        return "acte/show";
    }

    @RequestMapping("/acte/new")
    public String showNewForm(Model model) {
        Acte acte = new Acte();
        model.addAttribute("acte", acte);
        return "acte/new_form";
    }

    @RequestMapping(value = "/acte/save", method = RequestMethod.POST)
    public String saveActe(@ModelAttribute("acte") Acte acte) {
        acteDAO.save(acte);
        return "redirect:/acte";
    }

    @RequestMapping("/acte/edit/{id_act}")
    public ModelAndView showEditFormActe(@PathVariable(name = "id_act") Integer idAct) {
        ModelAndView mav = new ModelAndView("acte/edit_form");
        Acte acte = acteDAO.get(idAct);
        mav.addObject("acte", acte);
        return mav;
    }

    @RequestMapping(value = "/acte/update", method = RequestMethod.POST)
    public String updateActe(@ModelAttribute("acte") Acte acte) {
        acteDAO.update(acte);
        return "redirect:/acte";
    }

    @RequestMapping("/acte/delete/{id_act}")
    public String deleteActe(@PathVariable(name = "id_act") Integer idAct) {
        acteDAO.delete(idAct);
        return "redirect:/acte";
    }
}
