package in.codewithbalaji.portfolio.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController implements ErrorController {

    @GetMapping({"/","","/home"})
    public String showHomePage(Model model) {
        model.addAttribute("title","Home");
        return "master";
    }

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("title","Contact");
        return "master";
    }

    @GetMapping("/projects")
    public String showProjectsPage(Model model) {
        model.addAttribute("title","Projects");
        return "master";
    }    @GetMapping("/resume")
    public String showResumePage(Model model) {
        model.addAttribute("title","Resume");
        return "master";
    }

    @GetMapping("/thankyou")
    public String showThankYouPage(Model model) {
        model.addAttribute("title","Thank You");
        return "master";
    }

    @GetMapping("/404")
    public String show404Page(Model model) {
        model.addAttribute("title","404 - Page Not Found");
        return "master";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            
            if (statusCode == 404) {
                model.addAttribute("title","404 - Page Not Found");
                return "master";
            }
        }
        
        // For other errors, also show 404 page
        model.addAttribute("title","404 - Page Not Found");
        return "master";
    }
}
