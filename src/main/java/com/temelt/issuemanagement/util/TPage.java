package com.temelt.issuemanagement.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public class TPage<T> {
    private int number;
    private int size;
    private int totalPages;
    private Sort sort;
    private List<T> content;
    private Long totalElements;

    public void setStat(Page page,List<T> list){

        this.number=page.getNumber();
        this.content=list;
        this.totalElements=page.getTotalElements();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPages=page.getTotalPages();
    }
}
