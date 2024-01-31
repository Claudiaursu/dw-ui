package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.pieseDAO;
import proiectOpera.model.Piese;

import java.util.List;

@Controller
public class PieseController {

    @Autowired
    private pieseDAO dao;

    @RequestMapping("/piese")
    public String viewHomePage(Model model) {
        List<Piese> lista_opere = dao.list();
        model.addAttribute("lista_opere", lista_opere);
        return "piese/show";
    }

    @RequestMapping("/piese/new")
    public String showNewForm(Model model) {
        Piese piesa = new Piese();
        model.addAttribute("piesa", piesa);

        return "piese/new_form";
    }

    @RequestMapping(value = "/piese/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("piese") Piese piesa) {
        dao.save(piesa);

        return "redirect:/piese";
    }

    @RequestMapping("/piese/edit/{titlu_piesa}")
    public ModelAndView showEditForm(@PathVariable(name = "titlu_piesa") String titlu_piesa) {
        ModelAndView mav = new ModelAndView("piese/edit_form");
        Piese piesa = dao.get(titlu_piesa);
        mav.addObject("piesa", piesa);

        return mav;
    }

    @RequestMapping(value = "/piese/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("piese") Piese piesa) {
        dao.update(piesa);

        return "redirect:/piese";
    }

    @RequestMapping("/piese/delete/{titlu_piesa}")
    public String delete(@PathVariable(name = "titlu_piesa") Integer titlu_piesa) {
        dao.delete(titlu_piesa);
        return "redirect:/piese";
    }
}
