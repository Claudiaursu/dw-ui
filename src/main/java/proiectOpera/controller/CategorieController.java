package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.CategorieDAO;
import proiectOpera.model.Categorie;

import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    private CategorieDAO dao;

    @RequestMapping("/categorie")
    public String viewHomePage(Model model) {
        List<Categorie> listCategorie = dao.list();
        model.addAttribute("listCategorie", listCategorie);
        return "categorie/show";
    }

    @RequestMapping("/categorie/new")
    public String showNewForm(Model model) {
        Categorie categorie = new Categorie();
        model.addAttribute("categorie", categorie);
        return "categorie/new_form";
    }

    @RequestMapping(value = "/categorie/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("categorie") Categorie categorie) {
        dao.save(categorie);
        return "redirect:/categorie";
    }

    @RequestMapping("/categorie/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("categorie/edit_form");
        Categorie categorie = dao.get(id);
        mav.addObject("categorie", categorie);
        return mav;
    }

    @RequestMapping(value = "/categorie/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("categorie") Categorie categorie) {
        dao.update(categorie);
        return "redirect:/categorie";
    }

    @RequestMapping("/categorie/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        dao.delete(id);
        return "redirect:/categorie";
    }
}
