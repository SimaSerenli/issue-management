package com.temelt.issuemanagement.api;

import com.temelt.issuemanagement.dto.ProjectDto;
import com.temelt.issuemanagement.services.implemantation.ProjectServiceImplementation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")// proje yolunu belirtir
public class ProjectController {
    /*HTTP methodları*/
    private ProjectServiceImplementation projectServiceImplementation;
    public ProjectController(ProjectServiceImplementation projectServiceImplementation){
        this.projectServiceImplementation = projectServiceImplementation;
    }

    /*Web restful servis modeli haline getirmek için getMapping kullanıldı
        *RestfulMapping veMapping daha geniş kapsamlıdır */
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id){

        ProjectDto projectDto=projectServiceImplementation.getById(id);
        return ResponseEntity.ok(projectDto);
        //Yapılan bu işlem sonrası localhost:8080/h2-console üzerinden project nesnesi oluşturulur
        //nesneya ait id ile localhost:8080/project/id adresi üzerinden sonuç alınır
    }
}
