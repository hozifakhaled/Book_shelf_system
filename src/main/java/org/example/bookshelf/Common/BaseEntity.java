package org.example.bookshelf.Common;

import java.time.LocalDateTime;

import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public abstract class BaseEntity {
    @CreatedDate
 private  LocalDateTime createdAt;
@LastModifiedDate
 private LocalDateTime lastModifiedDate;
}
