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
        Technology java = new Technology("Java", "#F58E27","devicon-java-plain" );
        Technology vue = new Technology( "Vue", "#27F56C", "devicon-vuejs-plain" );
        Technology csharp = new Technology("Csharp", "#264de4",  "devicon-csharp-plain");
        Technology c = new Technology( "C", "#F58E27", "devicon-c-plain");
        Technology cmake = new Technology( "Cmake", "#F58E27", "devicon-cmake-plain");
        Technology python = new Technology( "Python", "#F58E27", "devicon-python-plain");

        List<Technology> wiedzminTech = List.of(html, css, js);

        Project wiedzminProject = new Project(
                "The Witcher Website",
                "Projekt szkolny - interaktywna strona o świecie Wiedźmina.",
                LocalDate.of(2023, 10, 20),
                "banner.jpg",
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

        List<Technology> kryptoTech = List.of(java);

        Project kryptoProject = new Project(
                "Kryptografia",
                "Projekt studencki - poznanie zasad działania DES'a. ",
                LocalDate.of(2026, 4, 1),
                "krypto.png",
                "https://github.com/VEXORjs/krypto",
                kryptoTech,
                ""
        );

        projects.add(kryptoProject);

        List<Technology> vueTech = List.of(html, css, js, vue);

        Project vueProject = new Project(
                "TODO Web App",
                "Basic TODO App.",
                LocalDate.of(2022, 1, 1),
                "todo.png",
                "https://github.com/VEXORjs/TODO-WEB-App/tree/master",
                vueTech,
                "https://todo-web-app-ten.vercel.app/"
        );

        projects.add(vueProject);

        List<Technology> concurrentTech = List.of(csharp);

        Project concurrentProject = new Project(
                "Programowanie współbieżne - gra w bilard",
                "Poznanie zasad programowania współbieżnego",
                LocalDate.of(2026, 3, 1),
                "wspolbiegi.png",
                "https://github.com/VEXORjs/Kurs-programowanie-wspolbiezne",
                concurrentTech,
                ""
        );

        projects.add(concurrentProject);

        List<Technology> embeddedTech = List.of(c, cmake);

        Project embeddedProject = new Project(
                "Systemy wbudowane - stacja pogodowa",
                "Bliska praca z elektroniką",
                LocalDate.of(2026, 3, 2),
                "wbudy.png",
                "https://github.com/VEXORjs/stacja_pogodowa",
                embeddedTech,
                ""
        );

        projects.add(embeddedProject);

        List<Technology> AITech = List.of(python);

        Project AITechProject = new Project(
                "Gra w 15tke",
                "Stworzenie prostej gry logicznej",
                LocalDate.of(2026, 3, 12),
                "sise.png",
                "https://github.com/VEXORjs/15-Puzzle-game-Analysis",
                AITech,
                ""
        );

        projects.add(AITechProject);
    }
    List<Project> getProjects() {
        return projects;
    }
}
