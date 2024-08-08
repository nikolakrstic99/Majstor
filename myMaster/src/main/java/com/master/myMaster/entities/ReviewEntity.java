package com.master.myMaster.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review")
public class ReviewEntity {

  @Id
  private Long id;
}
