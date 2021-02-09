package com.temelt.issuemanagement.repo;

import com.temelt.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRespository extends JpaRepository<Issue,Long> {
}
