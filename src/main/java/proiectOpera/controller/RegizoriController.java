package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.RegizoriDAO;
import proiectOpera.model.Regizori;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class RegizoriController {

    @Autowired
    private RegizoriDAO dao;

    @RequestMapping("/regizori")
    public String viewHomePage(Model model) {
        List<Regizori> listaRegizori = dao.list();
        model.addAttribute("listaRegizori", listaRegizori);
        return "regizori/show";
    }

    @RequestMapping("/regizori/new")
    public String showNewForm(Model model) {
        Regizori regizor = new Regizori();
        model.addAttribute("regizor", regizor);

        return "regizori/new_form";
    }

    @RequestMapping(value = "/regizori/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Regizori") Regizori regizor) {
        dao.save(regizor);

        return "redirect:/regizori";
    }

    @RequestMapping("/regizori/edit/{id_regizor}")
    public ModelAndView showEditForm(@PathVariable(name = "id_regizor") int id_regizor) {
        ModelAndView mav = new ModelAndView("regizori/edit_form");
        Regizori regizor = dao.get(id_regizor);
        mav.addObject("regizor", regizor);

        return mav;
    }

    @RequestMapping(value = "/regizori/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Regizori") Regizori regizor) {
        dao.update(regizor);

        return "redirect:/regizori";
    }

    @RequestMapping("/regizori/delete/{id_regizor}")
    public String delete(@PathVariable(name = "id_regizor") int id_regizor) {
        dao.delete(id_regizor);
        return "redirect:/regizori";
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
