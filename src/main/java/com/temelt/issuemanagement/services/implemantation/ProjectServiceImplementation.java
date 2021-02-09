package com.temelt.issuemanagement.services.implemantation;

import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.repo.ProjectRepository;
import com.temelt.issuemanagement.services.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ProjectServiceImplementation implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImplementation(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode()==null){
            throw new IllegalArgumentException("Project code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
