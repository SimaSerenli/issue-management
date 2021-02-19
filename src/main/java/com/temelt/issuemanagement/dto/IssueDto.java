package com.temelt.issuemanagement.dto;

import com.temelt.issuemanagement.entity.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class IssueDto {
    private Long id;
    private String description;
    private Date date;
    private IssueStatus issueStatus;
    private String details;
    private UserDto assignee;
    private ProjectDto project;
}
