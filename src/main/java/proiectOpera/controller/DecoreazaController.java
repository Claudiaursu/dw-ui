package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.DecoreazaDAO;
import proiectOpera.model.Decoreaza;

import java.util.List;

@Controller
public class DecoreazaController {

    @Autowired
    private DecoreazaDAO dao;

    @RequestMapping("/decoreaza")
    public String viewHomePage(Model model) {
        List<Decoreaza> listaDecor = dao.list();
        model.addAttribute("listaDecor", listaDecor);
        return "decoreaza/show";
    }

    @RequestMapping("/decoreaza/new")
    public String showNewForm(Model model) {
        Decoreaza decor = new Decoreaza();
        model.addAttribute("decor", decor);

        return "decoreaza/new_form";
    }

    @RequestMapping(value = "/decoreaza/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Decoreaza") Decoreaza decor) {
        dao.save(decor);

        return "redirect:/decoreaza";
    }

    @RequestMapping("/decoreaza/edit/{id_act}/{id_recuzita}")
    public ModelAndView showEditForm(@PathVariable(name = "id_act") int id_act, @PathVariable(name = "id_recuzita") int id_recuzita) {
        ModelAndView mav = new ModelAndView("decoreaza/edit_form");
        Decoreaza decor = dao.get(id_act,id_recuzita);
        mav.addObject("decor", decor);

        return mav;
    }

    @RequestMapping(value = "/decoreaza/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Decoreaza") Decoreaza decor) {
        dao.update(decor);

        return "redirect:/decoreaza";
    }

    @RequestMapping("/decoreaza/delete/{id_act}/{id_recuzita}")
    public String delete(@PathVariable(name = "id_act") int id_act, @PathVariable(name = "id_recuzita") int id_recuzita) {
        dao.delete(id_act,id_recuzita);
        return "redirect:/decoreaza";
    }
}
