package com.master.myMaster.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "master")
public class MasterEntity {

  @Id
  private Long id;

}
