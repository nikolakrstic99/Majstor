package com.master.myMaster.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog")
public class BlogEntity {

  @Id
  private Long id;

}
