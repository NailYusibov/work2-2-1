package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findUserByCar(String model, long series) {
      Session session=sessionFactory.getCurrentSession();
      String hql="FROM User u WHERE u.car.model=:fakemodel AND u.car.series=:fakeseries";
      return session.createQuery(hql,User.class).setParameter("fakemodel",model).setParameter("fakeseries",series).getSingleResult();
   }
}
