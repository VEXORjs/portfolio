package job.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PortfolioController {

    private final ProjectProvider projectProvider;

    public PortfolioController(ProjectProvider projectProvider) {
        this.projectProvider = projectProvider;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Project> topProjects = projectProvider.getProjects()
                .stream()
                .limit(3)
                .toList();

        model.addAttribute("projects", topProjects);
        model.addAttribute("isHomePage", true);
        return "home";
    }

    @GetMapping("/projects")
    public String showPortfolio(Model model) {
        model.addAttribute("projects", projectProvider.getProjects());
        return "projects";
    }
}