package job.portfolio;

import java.time.LocalDate;
import java.util.List;

public class Project {
    private final String title;
    private final String description;
    private final LocalDate creationDate;
    private final String thumbnailUrl;
    private final String githubUrl;
    private final List<Technology> technologies;

    public Project(String title, String description, LocalDate creationDate, String thumbnailUrl, String githubUrl, List<Technology> technologies) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.thumbnailUrl = thumbnailUrl;
        this.githubUrl = githubUrl;
        this.technologies = technologies;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
}
