package com.temelt.issuemanagement.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
@Data
// bu data sayesinde içindeki elementlerin getter ve setter larını lombok otomatik
//aslında bir interface runtime ve comile time da bazı özellikler kazandırır
@MappedSuperclass
//diğer classlardan extend edilebilir bir hale gelmesini sağlar
public abstract class BaseEntity implements Serializable {
    //@Data lombok u yerine her bir element için elementin üst kısmına da Getter Setter eklenebilir
    //@Getter @Setter
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt; // kayıt oluşturulma zamanı
    @Column(name = "created_by",length = 100)
    private String createdBy; //kim ekledi
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "updated_by",length = 100)
    private String updatedBy;
    @Column(name = "status")
    Boolean status;//kaydın aktif olma durumu


}
