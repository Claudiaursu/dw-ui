package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.ActoriDAO;
import proiectOpera.model.Actori;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class ActoriController {

    @Autowired
    private ActoriDAO dao;

    @RequestMapping("/actori")
    public String viewHomePage(Model model) {
        List<Actori> listaActori = dao.list();
        model.addAttribute("listaActori", listaActori);
        return "actori/show";
    }

    @RequestMapping("/actori/new")
    public String showNewForm(Model model) {
        Actori actor = new Actori();
        model.addAttribute("actor", actor);

        return "actori/new_form";
    }

    @RequestMapping(value = "/actori/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("actor") Actori actor) {
        dao.save(actor);

        return "redirect:/actori";
    }

    @RequestMapping("/actori/edit/{id_actor}")
    public ModelAndView showEditForm(@PathVariable(name = "id_actor") int id_actor) {
        ModelAndView mav = new ModelAndView("actori/edit_form");
        Actori actor = dao.get(id_actor);
        mav.addObject("actor", actor);

        return mav;
    }

    @RequestMapping(value = "/actori/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Actori") Actori actor) {
        dao.update(actor);

        return "redirect:/actori";
    }

    @RequestMapping("/actori/delete/{id_actor}")
    public String delete(@PathVariable(name = "id_actor") int id_actor) {
        dao.delete(id_actor);
        return "redirect:/actori";
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
