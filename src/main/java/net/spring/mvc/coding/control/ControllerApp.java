package net.spring.mvc.coding.control;

import net.spring.mvc.coding.model.Contact;
import net.spring.mvc.coding.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

@Controller
public class ControllerApp {

    private CustomerRepository customerRepository;

    @Autowired
    public ControllerApp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String start() {
        return "home-app";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    private String home() {
        return "home-app";
    }

    @RequestMapping(value = "/views", method = RequestMethod.GET)
    private String viewsCustomer(Model model) {
        List<Contact> contactList = customerRepository.views();
        model.addAttribute("customerList", contactList);
        return "views-app";
    }

    @RequestMapping(value = "/edite/{id}", method = RequestMethod.GET)
    private String editeCustomer(Model model, @PathVariable Long id) {
        Contact contact = (Contact) customerRepository.view(id);
        model.addAttribute("customer", contact);
        return "edite-app";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    private String deleteCustomer(@PathVariable Long id) {
        HashMap<String, Long> response = (HashMap<String, Long>) customerRepository.delete(id);
        return "redirect:/views";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    private String createCustomer(@ModelAttribute Contact contact) {
        HashMap<String, Contact> response = customerRepository.create(contact);
        System.out.println(response);
        return "redirect:/views";
    }

    @RequestMapping(value = "/edite", method = RequestMethod.POST)
    private String editeCustomer(@ModelAttribute Contact contact) {
        HashMap<String, Contact> response = customerRepository.edite(contact);
        System.out.println(response);
        return "redirect:/views";
    }


}
