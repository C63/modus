package fi.studio.c63.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
public class Project {

    @Id
    @Column(name = "project_id")
    private UUID id;

    private String projectName;

    private String projectDescription;

    private Boolean enabled;

    @ManyToMany(mappedBy = "projects")
    private List<Account> accounts;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
