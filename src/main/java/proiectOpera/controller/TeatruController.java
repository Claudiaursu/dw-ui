package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.TeatruDAO;
import proiectOpera.model.Teatru;

import java.util.List;

@Controller
public class TeatruController {

    @Autowired
    private TeatruDAO teatruDAO;

    @RequestMapping("/teatre")
    public String viewAllTeatre(Model model) {
        List<Teatru> listTeatre = teatruDAO.list();
        model.addAttribute("listTeatre", listTeatre);
        return "teatre/show";
    }

    @RequestMapping("/teatre/new")
    public String showNewTeatruForm(Model model) {
        Teatru teatru = new Teatru();
        model.addAttribute("teatru", teatru);
        return "teatre/new_form";
    }

    @RequestMapping(value = "/teatre/save", method = RequestMethod.POST)
    public String saveTeatru(@ModelAttribute("teatru") Teatru teatru) {
        teatruDAO.save(teatru);
        return "redirect:/teatre";
    }

    @RequestMapping("/teatre/edit/{id_teatru}")
    public ModelAndView showEditTeatruForm(@PathVariable(name = "id_teatru") int id_teatru) {
        ModelAndView mav = new ModelAndView("teatre/edit_form");
        Teatru teatru = teatruDAO.get(id_teatru);
        mav.addObject("teatru", teatru);
        return mav;
    }

    @RequestMapping(value = "/teatre/update", method = RequestMethod.POST)
    public String updateTeatru(@ModelAttribute("teatru") Teatru teatru) {
        teatruDAO.update(teatru);
        return "redirect:/teatre";
    }

    @RequestMapping("/teatre/delete/{id_teatru}")
    public String deleteTeatru(@PathVariable(name = "id_teatru") int id_teatru) {
        teatruDAO.delete(id_teatru);
        return "redirect:/teatre";
    }
}
