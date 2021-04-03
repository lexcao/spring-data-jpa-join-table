package io.github.lexcao.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private String id;
    private Integer score;
}
