package de.hse.swa.jodel.orm.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.hse.swa.jodel.orm.model.Comment;
import de.hse.swa.jodel.orm.model.User;
import de.hse.swa.jodel.orm.model.Voting;

@ApplicationScoped
public class VotingDao{

    @Inject
    EntityManager em;

    public List<Voting> getAllVoting() {
        TypedQuery<Voting> query = em.createQuery("SELECT u FROM Voting u", Voting.class);
        List<Voting> results = query.getResultList();
        return results;
    }

    public List<Voting> getVotings(Long commentId) {
        TypedQuery<Voting> query = em.createQuery("SELECT * FROM Voting where commentId ="+  commentId, Voting.class);
        List<Voting> results = query.getResultList();
        return results;
    }

    public Voting getVoting(Long commentId, Long authorId)
    {
        TypedQuery<Voting> query = em.createQuery("SELECT u FROM Voting u where u.commentId ="+  commentId + " and u.authorId = " + authorId, Voting.class);
        List<Voting> results = query.getResultList();
        if(results.isEmpty()) return null;
        return results.get(0);
    }

    public List<Voting> getLikes(Long commentId)
    {
        TypedQuery<Voting> query = em.createQuery("SELECT u FROM Voting u where u.commentId = "+  commentId + " and u.value = 1", Voting.class);
        List<Voting> results = query.getResultList();
        return results;
    }

    public List<Voting> getDislikes(Long commentId)
    {
        TypedQuery<Voting> query = em.createQuery("SELECT u FROM Voting u where u.commentId = "+  commentId + " and u.value = -1", Voting.class);
        List<Voting> results = query.getResultList();
        return results;
    }

    public Voting getVoting(Long id) {

        return em.find(Voting.class, id);
    }


    @Transactional
    public Voting updateVoting(Voting voting) {
        em.merge(voting);
        return voting;
    }

    @Transactional
    public Voting save(Voting voting) {
        if (voting.getId() != null) {
            voting = em.merge(voting);
        } else {
            em.persist(voting);
        }
        return voting;
    }

    @Transactional
    public Voting upvote(Long userId, Long commentId){
        Voting vote = new Voting(1);
        vote.setAuthorId(userId);
        vote.setCommentId(commentId);

        Voting found = getVoting(commentId, userId);

        //wenn kein vote zu dem user und dem kommentar gefunden wurde, erstelle einen neuen
        if(found == null) {
            if (vote.getId() != null) {
                vote = em.merge(vote);
            } else {
                em.persist(vote);
            }

            //wenn ein vote gefunden wird, dieser aber anderst ist, wird der bisherige geändert
        }else if(found.getValue() == -1)
        {
            found.setValue(1);
            vote = em.merge(found);
        }
        return vote;
    }

    @Transactional
    public Voting downvote(Long userId, Long commentId){


        Voting vote = new Voting(-1);
        vote.setAuthorId(userId);
        vote.setCommentId(commentId);

        Voting found = getVoting(commentId, userId);

        //wenn kein vote zu dem user und dem kommentar gefunden wurde, erstelle einen neuen
        if(found == null) {

            if (vote.getId() != null) {
                vote = em.merge(vote);
            } else {
                em.persist(vote);
            }
            //wenn ein vote gefunden wird, dieser aber anderst ist, wird der bisherige geändert
        }else if(found.getValue() == 1)
        {
            found.setValue(-1);
            vote = em.merge(found);
        }
        return vote;
    }

    @Transactional
    public void removeVoting(Voting voting) {

        em.remove(voting);
    }

    @Transactional
    public void deleteAllVotings() {
        try {

            Query del = em.createQuery("DELETE FROM Voting WHERE id >= 0");
            del.executeUpdate();

        } catch (SecurityException | IllegalStateException  e) {
            e.printStackTrace();
        }

        return;
    }


}