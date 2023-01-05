/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.List;
import ma.projet.classes.Employe;
import ma.projet.classes.Projet;
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
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
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
        public Employe getById
        (int id)
        
             {
        Session session = null;
        Transaction tx = null;
        Employe employe=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe=(Employe) session.get(Employe.class,id);
            tx.commit();
            return employe;
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
        

        
        public List<Tache> getTachesByEmployes(int id) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("select et.tache from EmployeTache et where et.employe=:dog");
            query.setInteger("dog",id);
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
public List<Projet> getProjetsByEmployes(int id) {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("from Projet p where p.employe=:dog");
            query.setInteger("dog",id);
            projets=query.list();
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
        return projets;
}
            @Override
        public List<Employe> getAll
        
            () {
        Session session = null;
        Transaction tx = null;
        List<Employe> employes=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes=session.createQuery("from Employe").list();
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
        return employes;
}
    

    }
