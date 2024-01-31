package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.TaraDAO;
import proiectOpera.model.Tara;

import java.util.List;

@Controller
public class TaraController {

    @Autowired
    private TaraDAO taraDAO;

    @RequestMapping("/tari")
    public String viewAllTari(Model model) {
        List<Tara> listaTari = taraDAO.list();
        model.addAttribute("listaTari", listaTari);
        return "tari/show";
    }

    @RequestMapping("/tari/new")
    public String showNewTaraForm(Model model) {
        Tara tara = new Tara();
        model.addAttribute("tara", tara);
        return "tari/new_form";
    }

    @RequestMapping(value = "/tari/save", method = RequestMethod.POST)
    public String saveTara(@ModelAttribute("tara") Tara tara) {
        taraDAO.save(tara);
        return "redirect:/tari";
    }

    @RequestMapping("/tari/edit/{id_tara}")
    public ModelAndView showEditTaraForm(@PathVariable(name = "id_tara") int id_tara) {
        ModelAndView mav = new ModelAndView("tari/edit_form");
        Tara tara = taraDAO.get(id_tara);
        mav.addObject("tara", tara);
        return mav;
    }

    @RequestMapping(value = "/tari/update", method = RequestMethod.POST)
    public String updateTara(@ModelAttribute("tara") Tara tara) {
        taraDAO.update(tara);
        return "redirect:/tari";
    }

    @RequestMapping("/tari/delete/{id_tara}")
    public String deleteTara(@PathVariable(name = "id_tara") int id_tara) {
        taraDAO.delete(id_tara);
        return "redirect:/tari";
    }

}
