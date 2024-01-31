package proiectOpera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import proiectOpera.dao.ReprezentatieDAO;
import proiectOpera.model.Reprezentatie;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@Controller
public class ReprezentatieController {

    @Autowired
    private ReprezentatieDAO dao;

    @RequestMapping("/reprezentatii")
    public String viewHomePage(Model model) {
        List<Reprezentatie> listaReprezentatii = dao.list();
        model.addAttribute("listaReprezentatii", listaReprezentatii);
        return "reprezentatii/show";
    }

    @RequestMapping("/reprezentatii/new")
    public String showNewForm(Model model) {
        Reprezentatie reprezentatie = new Reprezentatie();
        model.addAttribute("reprezentatie", reprezentatie);

        return "reprezentatii/new_form";
    }

    @RequestMapping(value = "/reprezentatii/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Reprezentatie") Reprezentatie reprezentatie) {
        dao.save(reprezentatie);

        return "redirect:/reprezentatii";
    }

    @RequestMapping("/reprezentatii/edit/{id_reprezentatie}")
    public ModelAndView showEditForm(@PathVariable(name = "id_reprezentatie") int id_reprezentatie) {
        ModelAndView mav = new ModelAndView("reprezentatii/edit_form");
        Reprezentatie reprezentatie = dao.get(id_reprezentatie);
        mav.addObject("reprezentatie", reprezentatie);

        return mav;
    }

//    @RequestMapping("/reprezentatii/edit/{id_reprezentatie}")
//    public ModelAndView showEditForm(@PathVariable(name = "id_reprezentatie") int id_reprezentatie) {
//        ModelAndView mav = new ModelAndView("reprezentatii/edit_form");
//        Reprezentatie reprezentatie = dao.get(id_reprezentatie);
//
//        // Convert the Timestamp to a String for the HTML form
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        String formattedDate = dateFormat.format(reprezentatie.getData_ora_reprezentatie());
//
//        reprezentatie.setFormattedDataOraReprezentatie(formattedDate);
//        mav.addObject("reprezentatie", reprezentatie);
//
//        return mav;
//    }


    @RequestMapping(value = "/reprezentatii/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("Reprezentatie") Reprezentatie reprezentatie) {
        dao.update(reprezentatie);

        return "redirect:/reprezentatii";
    }

//    @RequestMapping(value = "/reprezentatii/update", method = RequestMethod.POST)
//    public String update(@ModelAttribute("Reprezentatie") Reprezentatie reprezentatie) {
//        // Convert the formatted date to Timestamp
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        //Date parsedDate = dateFormat.parse();
//        reprezentatie.setData_ora_reprezentatie(new Timestamp(reprezentatie.getData_ora_reprezentatie().getTime()));
//
//        dao.update(reprezentatie);
//
//        return "redirect:/reprezentatii";
//    }



    @RequestMapping("/reprezentatii/delete/{id_reprezentatie}")
    public String delete(@PathVariable(name = "id_reprezentatie") int id_reprezentatie) {
        dao.delete(id_reprezentatie);
        return "redirect:/reprezentatii";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    LocalDateTime localDateTime = LocalDateTime.parse(text);
                    setValue(Timestamp.valueOf(localDateTime));
                } catch (DateTimeParseException e) {
                    setValue(null);
                }
            }

            @Override
            public String getAsText() {
                if (getValue() == null) {
                    return null;
                }
                LocalDateTime localDateTime = ((Timestamp) getValue()).toLocalDateTime();
                return localDateTime.toString();
            }
        });
    }

}
