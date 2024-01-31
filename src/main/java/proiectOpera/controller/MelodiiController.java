package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.MelodiiDAO;
import proiectOpera.model.Melodii;

import java.util.List;

@Controller
public class MelodiiController {

    @Autowired
    private MelodiiDAO dao;

    @RequestMapping("/melodii")
    public String viewHomePage(Model model) {
        List<Melodii> listaMelodii = dao.list();
        model.addAttribute("listaMelodii", listaMelodii);
        return "melodii/show";
    }

    @RequestMapping("/melodii/new")
    public String showNewForm(Model model) {
        Melodii melodie = new Melodii();
        model.addAttribute("melodie", melodie);

        return "melodii/new_form";
    }

    @RequestMapping(value = "/melodii/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Melodii") Melodii melodie) {
        dao.save(melodie);

        return "redirect:/melodii";
    }

    @RequestMapping("/melodii/edit/{id_melodie}")
    public ModelAndView showEditForm(@PathVariable(name = "id_melodie") int id_melodie) {
        ModelAndView mav = new ModelAndView("melodii/edit_form");
        Melodii melodie = dao.get(id_melodie);
        mav.addObject("melodie", melodie);

        return mav;
    }

    @RequestMapping(value = "/melodii/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Melodii") Melodii melodie) {
        dao.update(melodie);

        return "redirect:/melodii";
    }

    @RequestMapping("/melodii/delete/{id_melodie}")
    public String delete(@PathVariable(name = "id_melodie") int id_melodie) {
        dao.delete(id_melodie);
        return "redirect:/melodii";
    }
}
