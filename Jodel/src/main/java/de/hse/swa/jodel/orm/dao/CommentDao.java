package de.hse.swa.jodel.orm.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.hse.swa.jodel.orm.model.Comment;


@ApplicationScoped
public class CommentDao {

    @Inject
    EntityManager em;


    public List<Comment> getComments(Long postId) {
        TypedQuery<Comment> query = em.createQuery("select u from Comment u where postId="+ postId, Comment.class);
        List<Comment> results = query.getResultList();
        return results;
    }


    public List<Comment> getAllComments() {
        TypedQuery<Comment> query = em.createQuery("SELECT u FROM Comment u", Comment.class);
        List<Comment> results = query.getResultList();
        return results;
    }

    public Comment getComment(Long id) {

        return em.find(Comment.class, id);
    }


    @Transactional
    public Comment save(Comment comment) {
        if (comment.getId() != null) {
            comment = em.merge(comment);
        } else {
            em.persist(comment);
        }
        return comment;
    }

    @Transactional
    public void removeComment(Comment comment) {

        em.remove(comment);
    }
}