package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.RecuzitaDAO;
import proiectOpera.model.Recuzita;

import java.util.List;

@Controller
public class RecuzitaController {

    @Autowired
    private RecuzitaDAO dao;

    @RequestMapping("/recuzita")
    public String viewHomePage(Model model) {
        List<Recuzita> listaRecuzita = dao.list();
        model.addAttribute("listaRecuzita", listaRecuzita);
        return "recuzita/show";
    }

    @RequestMapping("/recuzita/new")
    public String showNewForm(Model model) {
        Recuzita recuzita = new Recuzita();
        model.addAttribute("recuzita", recuzita);

        return "recuzita/new_form";
    }

    @RequestMapping(value = "/recuzita/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Recuzita") Recuzita recuzita) {
        dao.save(recuzita);

        return "redirect:/recuzita";
    }

    @RequestMapping("/recuzita/edit/{id_recuzita}")
    public ModelAndView showEditForm(@PathVariable(name = "id_recuzita") int id_recuzita) {
        ModelAndView mav = new ModelAndView("recuzita/edit_form");
        Recuzita recuzita = dao.get(id_recuzita);
        mav.addObject("recuzita", recuzita);

        return mav;
    }

    @RequestMapping(value = "/recuzita/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Recuzita") Recuzita recuzita) {
        dao.update(recuzita);

        return "redirect:/recuzita";
    }

    @RequestMapping("/recuzita/delete/{id_recuzita}")
    public String delete(@PathVariable(name = "id_recuzita") int id_recuzita) {
        dao.delete(id_recuzita);
        return "redirect:/recuzita";
    }
}
