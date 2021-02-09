package com.temelt.issuemanagement.services.implemantation;

import com.temelt.issuemanagement.entity.IssueHistory;
import com.temelt.issuemanagement.repo.IssueHistoryRepository;
import com.temelt.issuemanagement.services.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class IssueHistoryServiceImplementation implements IssueHistoryService{
    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImplementation(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate()==null){
            throw new IllegalArgumentException("date cannot be null");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
