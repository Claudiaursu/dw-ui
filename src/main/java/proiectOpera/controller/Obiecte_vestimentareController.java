package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.Obiecte_vestimentareDAO;
import proiectOpera.model.Obiecte_vestimentare;

import java.util.List;

@Controller
public class Obiecte_vestimentareController {

    @Autowired
    private Obiecte_vestimentareDAO dao;

    @RequestMapping("/obiecte_vestimentare")
    public String viewHomePage(Model model) {
        List<Obiecte_vestimentare> listaHaine = dao.list();
        model.addAttribute("listaHaine", listaHaine);
        return "obiecte_vestimentare/show";
    }

    @RequestMapping("/obiecte_vestimentare/new")
    public String showNewForm(Model model) {
        Obiecte_vestimentare haina = new Obiecte_vestimentare();
        model.addAttribute("haina", haina);

        return "obiecte_vestimentare/new_form";
    }

    @RequestMapping(value = "/obiecte_vestimentare/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Obiecte_vestimentare") Obiecte_vestimentare haina) {
        dao.save(haina);

        return "redirect:/obiecte_vestimentare";
    }

    @RequestMapping("/obiecte_vestimentare/edit/{id_obiect_vestimentar}")
    public ModelAndView showEditForm(@PathVariable(name = "id_obiect_vestimentar") int id_obiect_vestimentar) {
        ModelAndView mav = new ModelAndView("obiecte_vestimentare/edit_form");
        Obiecte_vestimentare haina = dao.get(id_obiect_vestimentar);
        mav.addObject("haina", haina);

        return mav;
    }

    @RequestMapping(value = "/obiecte_vestimentare/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Obiecte_vestimentare") Obiecte_vestimentare haina) {
        dao.update(haina);

        return "redirect:/obiecte_vestimentare";
    }

    @RequestMapping("/obiecte_vestimentare/delete/{id_obiect_vestimentar}")
    public String delete(@PathVariable(name = "id_obiect_vestimentar") int id_obiect_vestimentar) {
        dao.delete(id_obiect_vestimentar);
        return "redirect:/obiecte_vestimentare";
    }
}

