package job.portfolio;


import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectProvider {

private final List<Project> projects = new ArrayList<>();

    public ProjectProvider() {
        Technology html = new Technology("HTML", "#e34c26", "devicon-html5-plain");
        Technology css = new Technology("CSS", "#264de4", "devicon-css3-plain");
        Technology js = new Technology("JS", "#f7df1e",  "devicon-javascript-plain");

        List<Technology> wiedzminTech = List.of(html, css, js);

        Project wiedzminProject = new Project(
                "The Witcher Website",
                "Projekt szkolny - interaktywna strona o świecie Wiedźmina.",
                LocalDate.of(2023, 10, 20),
                "/banner.jpg",
                "https://github.com/VEXORjs/Wiedzmin_Strona",
                wiedzminTech,
                "https://wiedzmin-strona.vercel.app/");

        projects.add(wiedzminProject);

        //new projects go here

        List<Technology> gymTech = List.of(html, css, js);

        Project gymProject = new Project(
                "Gym City Website",
                "Projekt szkolny - projekt na zaliczenie semestru. ",
                LocalDate.of(2022, 12, 1),
                "gym.png",
                "https://github.com/VEXORjs/Gym_City",
                gymTech,
                "https://gym-city.vercel.app/");

        projects.add(gymProject);
    }
    List<Project> getProjects() {
        return projects;
    }
}
