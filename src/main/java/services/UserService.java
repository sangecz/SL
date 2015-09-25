package services;

import models.User;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by sange on 13/09/15.
 */
@Stateless
public class UserService  {

//    public UserService() {
//    }

    @PersistenceContext
    private EntityManager em;

     public List<User> getAll(){
         TypedQuery<User> query = em.createQuery("select u from  User u", User.class);
         return query.getResultList();
     }
}
