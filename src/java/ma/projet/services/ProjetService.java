/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.List;
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
public class ProjetService implements IDao<Projet> {

    @Override
    public boolean create(Projet o) {
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
        public Projet getById
        (int id)
        
             {
        Session session = null;
        Transaction tx = null;
        Projet projet=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projet=(Projet) session.get(Projet.class,id);
            tx.commit();
            return projet;
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
        public List<Projet> getAll
        
            () {
        Session session = null;
        Transaction tx = null;
        List<Projet> projets=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            projets=session.createQuery("from Projet").list();
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
public List<Tache> getTachesByProjet(int id) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("from Tache t where t.projet=:dog");
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
public List<Tache> AffichageByProjet(int id) {
        Session session = null;
        Transaction tx = null;
        List<Tache> taches=null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query query=session.createQuery("from Tache t where t.projet=:dog");
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
    public void question6(){
        ProjetService ps=new ProjetService();
        Projet p1=ps.getById(1);
        System.out.println("Projet:"+p1.getId()+"\t \t Nom: "+p1.getNom()+"\t \t Date debut: "+p1.getDateDebut());
        System.out.println("Liste des taches:\n");
        System.out.println("\t \tNum \t \tNom \t \tDate Debut Reelle       Date Fin Reelle \n");
        for (Tache t : ps.AffichageByProjet(1)) {
            System.out.println(t);
}
    }
}
