package com.temelt.issuemanagement.services.implemantation;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.entity.Project;
import com.temelt.issuemanagement.repo.ProjectRepository;
import com.temelt.issuemanagement.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplementation implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;


    public ProjectServiceImplementation(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Project save(Project project) {
        if (project.getProjectCode()==null){
            throw new IllegalArgumentException("Project code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto getById(Long id)
    {
        Project p= projectRepository.getOne(id);
        return modelMapper.map(p,ProjectDto.class);
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
