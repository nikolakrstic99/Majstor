package com.master.myMaster.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "review")
public class ReviewEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rated_user_id", referencedColumnName = "id")
  private UserEntity ratedUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "creator_user_id", referencedColumnName = "id")
  private UserEntity creatorUser;

  @Column(nullable = false)
  private String text;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private Integer rating;
}
