package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.BiletDAO;
import proiectOpera.model.Bilet;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class BiletController {

    @Autowired
    private BiletDAO dao;

    @RequestMapping("/bilete")
    public String viewHomePage(Model model) {
        List<Bilet> listaBilete = dao.list();
        model.addAttribute("listaBilete", listaBilete);
        return "bilete/show";
    }

    @RequestMapping("/bilete/new")
    public String showNewForm(Model model) {
        Bilet bilet = new Bilet();
        model.addAttribute("bilet", bilet);

        return "bilete/new_form";
    }

    @RequestMapping(value = "/bilete/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("bilet") Bilet bilet) {
        dao.save(bilet);

        return "redirect:/bilete";
    }

    @RequestMapping("/bilete/edit/{id_bilet}")
    public ModelAndView showEditForm(@PathVariable(name = "id_bilet") int id_bilet) {
        ModelAndView mav = new ModelAndView("bilete/edit_form");
        Bilet bilet = dao.get(id_bilet);
        mav.addObject("bilet", bilet);

        return mav;
    }

    @RequestMapping(value = "/bilete/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("bilet") Bilet bilet) {
        dao.update(bilet);

        return "redirect:/bilete";
    }

    @RequestMapping("/bilete/delete/{id_bilet}")
    public String delete(@PathVariable(name = "id_bilet") int id_bilet) {
        dao.delete(id_bilet);
        return "redirect:/bilete";
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
