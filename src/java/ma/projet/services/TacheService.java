/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.Date;
import java.util.List;
import ma.projet.classes.Tache;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tajine
 */
public class TacheService implements IDao<Tache> {

    @Override
    public boolean create(Tache o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return false;
}
        @Override
        public Tache getById
        (int id)
        
             {
        Session session = null;
        Transaction tx = null;
        Tache tache=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tache=(Tache) session.get(Tache.class,id);
            tx.commit();
            return tache;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
}
        

        @Override
        public List<Tache> getAll
        
            () {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            taches=session.createQuery("from Tache").list();
            tx.commit();
            
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return taches;
}

    public List<Tache> prixSup(double id) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("from Tache t where t.prix>:dog");
            query.setDouble("dog",id);
            taches=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return taches;
}
public List<Tache> EntreDeuxDate(Date d1,Date d2) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("from Tache t where t.dateFin between :d1 and :d2");
            query.setParameter("d1",d1);
            query.setParameter("d2",d2);
            taches=query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return taches;
}

    }

