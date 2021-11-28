/*========================================================================*
 *                                                                        *
 * This software is governed by the GPL version 2.                        *
 *                                                                        *
 * Copyright: Joerg Friedrich, University of Applied Sciences Esslingen   *
 *                                                                        *
 * $Id:$
 *                                                                        *
 *========================================================================*/
package de.hse.swa.jodel.orm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

// import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the POST database table.
 * 
 */
@Entity
public class Post implements Serializable {


	private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "postSeq", sequenceName = "ZSEQ_POST_ID", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "postSeq")
    
    @Column(name = "ID")
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "postText")
    private String postText;

    @Column(name = "postDate")
    private Date postDate;


    public Post() {
    }

    public Post(String postText, String user, Date postDate) {
        this.postText = postText;
        this.user = user;
        this.postDate = new Date();
    }


    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String postText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
    
}