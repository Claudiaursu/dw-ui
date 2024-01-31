package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.Piesa_Teatru_RegizorDAO;
import proiectOpera.model.Piesa_Teatru_Regizor;

import java.util.List;

@Controller
public class Piesa_Teatru_RegizorController {

    @Autowired
    private Piesa_Teatru_RegizorDAO dao;

    @RequestMapping("/regie")
    public String viewHomePage(Model model) {
        List<Piesa_Teatru_Regizor> listPiesaTeatruRegizor = dao.list();
        model.addAttribute("listPiesaTeatruRegizor", listPiesaTeatruRegizor);
        return "regie/show";
    }

    @RequestMapping("/regie/new")
    public String showNewForm(Model model) {
        Piesa_Teatru_Regizor piesaTeatruRegizor = new Piesa_Teatru_Regizor();
        model.addAttribute("piesaTeatruRegizor", piesaTeatruRegizor);
        return "regie/new_form";
    }

    @RequestMapping(value = "/regie/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("piesaTeatruRegizor") Piesa_Teatru_Regizor piesaTeatruRegizor) {
        dao.save(piesaTeatruRegizor);
        return "redirect:/regie";
    }

    @RequestMapping("/regie/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("regie/edit_form");
        Piesa_Teatru_Regizor piesaTeatruRegizor = dao.get(id);
        mav.addObject("piesaTeatruRegizor", piesaTeatruRegizor);
        return mav;
    }

    @RequestMapping(value = "/regie/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("piesaTeatruRegizor") Piesa_Teatru_Regizor piesaTeatruRegizor) {
        dao.update(piesaTeatruRegizor);
        return "redirect:/regie";
    }

    @RequestMapping("/regie/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        dao.delete(id);
        return "redirect:/regie";
    }
}
