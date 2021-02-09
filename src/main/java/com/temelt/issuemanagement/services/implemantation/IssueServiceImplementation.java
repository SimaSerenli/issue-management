package com.temelt.issuemanagement.services.implemantation;

import com.temelt.issuemanagement.dto.IssueDto;
import com.temelt.issuemanagement.entity.Issue;
import com.temelt.issuemanagement.repo.IssueRespository;
import com.temelt.issuemanagement.services.IssueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class IssueServiceImplementation implements IssueService {

    //tarih user da username null sa
    private final IssueRespository issueRespository;
    //nesne güvenli hala getirilir
    public IssueServiceImplementation(IssueRespository issueRespository){
        this.issueRespository= issueRespository;

    }

    @Override
    public IssueDto save(IssueDto issue) {
        if (issue.getDate()==null){
            throw new IllegalArgumentException("Issue date canoot be null");
        }
        return null;
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueDto> getAllPageable(Pageable pageable) {
        return null;
    }
}
