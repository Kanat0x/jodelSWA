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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


/**
 * The persistent class for the VOTING database table.
 * 
 */
@Entity
public class Voting implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @SequenceGenerator(name = "voteSeq", sequenceName = "ZSEQ_VOTE_ID", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "voteSeq")
	private Long id;
	
	@Column(name = "VALUE")
	private int value;

	@Column(name = "postId")
	private Long postId;

	@Column(name = "user")
	private String user;

	public Voting() {
	}

	public Voting(int value) {this.value = value;}

	public Long getpostId() {return postId;}

	public void setpostId() {this.postId = postId; }

	public int getValue() {return value;}

	public void setValue(int value) {this.value = value;}

	public String getUser() {return user;}

	public void setUser(String user) {this.user = user;}




}