package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.ActOrchestrantDAO;
import proiectOpera.model.Act_Orchestrant;

import java.util.List;

@Controller
public class ActOrchestrantController {

    @Autowired
    private ActOrchestrantDAO dao;

    @RequestMapping("/act_orchestrants")
    public String viewHomePage(Model model) {
        List<Act_Orchestrant> listActOrchestrants = dao.list();
        model.addAttribute("listActOrchestrants", listActOrchestrants);
        return "act_orchestrants/show";
    }

    @RequestMapping("/act_orchestrants/new")
    public String showNewForm(Model model) {
        Act_Orchestrant actOrchestrant = new Act_Orchestrant();
        model.addAttribute("actOrchestrant", actOrchestrant);

        return "act_orchestrants/new_form";
    }

    @RequestMapping(value = "/act_orchestrants/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("actOrchestrant") Act_Orchestrant actOrchestrant) {
        dao.save(actOrchestrant);

        return "redirect:/act_orchestrants";
    }

    @RequestMapping("/act_orchestrants/edit/{id_act}")
    public ModelAndView showEditForm(@PathVariable(name = "id_act") int id_act) {
        ModelAndView mav = new ModelAndView("act_orchestrants/edit_form");
        Act_Orchestrant actOrchestrant = dao.get(id_act);
        mav.addObject("actOrchestrant", actOrchestrant);

        return mav;
    }

    @RequestMapping(value = "/act_orchestrants/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("actOrchestrant") Act_Orchestrant actOrchestrant) {
        dao.update(actOrchestrant);

        return "redirect:/act_orchestrants";
    }

    @RequestMapping("/act_orchestrants/delete/{id_act}")
    public String delete(@PathVariable(name = "id_act") int id_act) {
        dao.delete(id_act);
        return "redirect:/act_orchestrants";
    }
}
