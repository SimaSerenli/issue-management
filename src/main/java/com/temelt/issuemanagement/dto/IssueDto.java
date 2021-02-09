package com.temelt.issuemanagement.dto;

import com.temelt.issuemanagement.entity.IssueStatus;
import lombok.Data;

import java.util.Date;

@Data

public class IssueDto {
    private Long id;
    private String description;
    private Date date;
    private IssueStatus issueStatus;
    private String details;
    private UserDto assignee;
    private ProjectDto project;
}
