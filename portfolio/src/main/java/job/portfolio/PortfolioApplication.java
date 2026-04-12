package job.portfolio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class PortfolioApplication {
    void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Portfolio Application");
        return "home";
    }
}
