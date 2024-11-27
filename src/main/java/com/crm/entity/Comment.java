package com.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false, length = 100)
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  public void setPost(Post post) {
    this.post = post;
  }


}