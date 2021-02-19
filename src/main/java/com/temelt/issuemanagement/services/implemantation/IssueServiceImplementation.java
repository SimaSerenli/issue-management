package com.temelt.issuemanagement.services.implemantation;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.repo.IssueRepository;
import com.temelt.issuemanagement.services.IssueService;
import com.temelt.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service

public class IssueServiceImplementation implements IssueService {

    //tarih user da username null sa
    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;
    //nesne güvenli hale getirilir
    public IssueServiceImplementation(IssueRepository issueRepository, ModelMapper modelMapper){
        this.issueRepository = issueRepository;

        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null){
            throw new IllegalArgumentException("Issue date cannot be null");
        }
        Issue issueDb = modelMapper.map(issue,Issue.class);
        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data= issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dto = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data, Arrays.asList(dto));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
