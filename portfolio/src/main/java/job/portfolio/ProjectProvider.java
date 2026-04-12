package job.portfolio;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectProvider {

private List<Project> projects = new ArrayList<>();

    public ProjectProvider() {
        Technology html = new Technology("HTML", "#e34c26", "devicon-html5-plain");
        Technology css = new Technology("CSS", "#264de4", "devicon-css3-plain");
        Technology js = new Technology("JS", "#f7df1e",  "devicon-javascript-plain");

        List<Technology> wiedzminTech = List.of(html, css, js);

        Project wiedzminProject = new Project(
                "The Witcher Website",
                "Projekt szkolny - interaktywna strona o świecie Wiedźmina.",
                LocalDate.of(2023, 10, 20),
                "/images/wiedzmin-thumb.png",
                "https://github.com/VEXORjs/Wiedzmin_Strona",
                wiedzminTech);

        projects.add(wiedzminProject);
    }
    List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
