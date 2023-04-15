package net.spring.mvc.coding.control;

import net.spring.mvc.coding.model.Customer;
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
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    private String start() {
        return "home-app";
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    private String home() {
        return "home-app";
    }
    @RequestMapping(value = "/views",method = RequestMethod.GET)
    private String viewsCustomer(Model model) {
        List<Customer> customerList = customerRepository.views();
        model.addAttribute("customerList" , customerList);
        return "views-app";
    }

    @RequestMapping(value = "/editeById/{id}",method = RequestMethod.GET)
    private String editeCustomer(Model model , @PathVariable Long id) {
        Customer customer = (Customer) customerRepository.view(id);
        model.addAttribute("customer" , customer);
        return "edite-app";
    }
    @RequestMapping(value = "/deleteById/{id}",method = RequestMethod.GET)
    private String deleteCustomer(Model model , @PathVariable Long id) {
        HashMap<String,Long> response = (HashMap<String,Long>) customerRepository.delete(id);
        System.out.println(response);
        return "redirect:/views";
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    private String createCustomer(@ModelAttribute Customer customer) {
        HashMap<String,Customer> response = customerRepository.create(customer);
        System.out.println(response);
        return "redirect:/views";
    }
    @RequestMapping(value = "/edite" , method = RequestMethod.POST)
    private String editeCustomer(@ModelAttribute Customer customer) {
        HashMap<String,Customer> response = customerRepository.edite(customer);
        System.out.println(response);
        return "redirect:/views";
    }




}
