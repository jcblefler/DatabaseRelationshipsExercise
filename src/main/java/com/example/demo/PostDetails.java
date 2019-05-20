package com.example.demo;

import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PostDetails")
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public PostDetails(){};

    public PostDetails(String createdBy){
        createdOn = new Date();
        this.createdBy = createdBy;
    }

    public Post getPost(){
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
