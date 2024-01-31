package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.InstrumenteDAO;
import proiectOpera.model.Instrumente;

import java.util.List;

@Controller
public class InstrumenteController {

    @Autowired
    private InstrumenteDAO dao;

    @RequestMapping("/instrumente")
    public String viewHomePage(Model model) {
        List<Instrumente> listaInstrumente = dao.list();
        model.addAttribute("listaInstrumente", listaInstrumente);
        return "instrumente/show";
    }

    @RequestMapping("/instrumente/new")
    public String showNewForm(Model model) {
        Instrumente instrument = new Instrumente();
        model.addAttribute("instrument", instrument);

        return "instrumente/new_form";
    }

    @RequestMapping(value = "/instrumente/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Instrumente") Instrumente instrument) {
        dao.save(instrument);

        return "redirect:/instrumente";
    }

    @RequestMapping("/instrumente/edit/{id_instrument}")
    public ModelAndView showEditForm(@PathVariable(name = "id_instrument") int id_instrument) {
        ModelAndView mav = new ModelAndView("instrumente/edit_form");
        Instrumente instrument = dao.get(id_instrument);
        mav.addObject("instrument", instrument);

        return mav;
    }

    @RequestMapping(value = "/instrumente/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Instrumente") Instrumente instrument) {
        dao.update(instrument);

        return "redirect:/instrumente";
    }

    @RequestMapping("/instrumente/delete/{id_instrument}")
    public String delete(@PathVariable(name = "id_instrument") int id_instrument) {
        dao.delete(id_instrument);
        return "redirect:/instrumente";
    }
}
