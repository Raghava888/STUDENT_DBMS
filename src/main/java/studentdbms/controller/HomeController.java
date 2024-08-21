/*
 * package studentdbms.controller;
 * 
 * import org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.ui.Model;
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * @Controller
 * 
 * @RequestMapping("/") public class HomeController {
 * 
 * @GetMapping("/login") public String home() { return "login"; // Return the
 * view name for the login page }
 * 
 * @PostMapping("/validate") public String login(String username, String
 * password, HttpSession session, Model model) { if ("raghava".equals(username)
 * && "pass".equals(password)) { session.setAttribute("username", username);
 * return "redirect:/students"; // Redirect to the student list on successful
 * login } else { model.addAttribute("error", "Invalid username or password");
 * return "login"; // Return to the login page on failure } } }
 */

package studentdbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import studentdbms.entity.User;
import studentdbms.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String home() {
        return "login"; // Return the view name for the login page
    }

    @PostMapping("/validate")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/students"; // Redirect to the student list on successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            model.addAttribute("showSignup", true); // Show signup button on login page
            return "login";
        }
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/register")
    public String signup(User user, Model model) {
        userRepository.save(user);
        model.addAttribute("successMessage", "Registered successfully! Please login.");
        return "redirect:/login";
    }
}





