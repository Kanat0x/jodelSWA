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

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the `COMMENT` database table.
 * 
 */
@Entity
public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "commentSeq", sequenceName = "ZSEQ_COMMENT_ID", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "commentSeq")

    @Column(name = "ID")
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "postText")
    private String postText;

    @Column(name = "postDate")
    private Date postDate;

    public Comment() {

    }
    public Comment(Long id, String user, String postText, Date postDate) {
        this.id = id;
        this.user = user;
        this.postText = postText;
        this.postDate = new Date();

    }
    public Comment(String postText) {
        this.postText = postText;
    }
    public Long getId() {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(){
        this.postDate = new Date();
    }



}