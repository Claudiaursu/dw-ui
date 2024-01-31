package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.AparitieDAO;
import proiectOpera.model.Aparitie;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Controller
public class AparitieController {

    @Autowired
    private AparitieDAO dao;

    @RequestMapping("/aparitii")
    public String viewHomePage(Model model) {
        List<Aparitie> listaAparitii = dao.list();
        model.addAttribute("listaAparitii", listaAparitii);
        return "aparitii/show";
    }

    @RequestMapping("/aparitii/new")
    public String showNewForm(Model model) {
        Aparitie aparitie = new Aparitie();
        model.addAttribute("aparitie", aparitie);

        return "aparitii/new_form";
    }

    @RequestMapping(value = "/aparitii/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Aparitie") Aparitie aparitie) {
        dao.save(aparitie);

        return "redirect:/aparitii";
    }

    @RequestMapping("/aparitii/edit/{id_aparitie}")
    public ModelAndView showEditForm(@PathVariable(name = "id_aparitie") int id_aparitie) {
        ModelAndView mav = new ModelAndView("aparitii/edit_form");
        Aparitie aparitie = dao.get(id_aparitie);
        mav.addObject("aparitie", aparitie);

        return mav;
    }

    @RequestMapping(value = "/aparitii/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Aparitie") Aparitie aparitie) {
        dao.update(aparitie);

        return "redirect:/aparitii";
    }

    @RequestMapping("/aparitii/delete/{id_aparitie}")
    public String delete(@PathVariable(name = "id_aparitie") int id_aparitie) {
        dao.delete(id_aparitie);
        return "redirect:/aparitii";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Add custom editors if needed
    }
}
