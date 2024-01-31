package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.OrchestrantiDAO;
import proiectOpera.model.Orchestranti;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class OrchestrantiController {

    @Autowired
    private OrchestrantiDAO dao;

    @RequestMapping("/orchestranti")
    public String viewHomePage(Model model) {
        List<Orchestranti> listaOrchestra = dao.list();
        model.addAttribute("listaOrchestra", listaOrchestra);
        return "orchestranti/show";
    }

    @RequestMapping("/orchestranti/new")
    public String showNewForm(Model model) {
        Orchestranti orchestrant = new Orchestranti();
        model.addAttribute("orchestrant", orchestrant);

        return "orchestranti/new_form";
    }

    @RequestMapping(value = "/orchestranti/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Orchestranti") Orchestranti orchestrant) {
        dao.save(orchestrant);

        return "redirect:/orchestranti";
    }

    @RequestMapping("/orchestranti/edit/{id_orchestrant}")
    public ModelAndView showEditForm(@PathVariable(name = "id_orchestrant") int id_orchestrant) {
        ModelAndView mav = new ModelAndView("orchestranti/edit_form");
        Orchestranti orchestrant = dao.get(id_orchestrant);
        mav.addObject("orchestrant", orchestrant);

        return mav;
    }

    @RequestMapping(value = "/orchestranti/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Orchestranti") Orchestranti orchestrant) {
        dao.update(orchestrant);

        return "redirect:/orchestranti";
    }

    @RequestMapping("/orchestranti/delete/{id_orchestrant}")
    public String delete(@PathVariable(name = "id_orchestrant") int id_orchestrant) {
        dao.delete(id_orchestrant);
        return "redirect:/orchestranti";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    LocalDate date = LocalDate.parse(text);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                    String formattedDate = date.format(formatter);
                    setValue(new SimpleDateFormat("dd-MMM-yyyy").parse(formattedDate));
                } catch (ParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                if (getValue() == null) {
                    return null;
                }
                return new SimpleDateFormat("dd-MMM-yyyy").format((Date) getValue());
            }
        });
    }
}
