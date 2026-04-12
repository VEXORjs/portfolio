package job.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    private final ProjectProvider projectProvider;

    public PortfolioController(ProjectProvider projectProvider) {
        this.projectProvider = projectProvider;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Portfolio Application");
        return "home";
    }

    @GetMapping("/projects")
    public String showPortfolio(Model model) {
        model.addAttribute("projects", projectProvider.getProjects());
        return "projects";
    }
}