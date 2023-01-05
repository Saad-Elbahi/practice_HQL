
import java.util.Date;
import ma.projet.classes.Employe;
import ma.projet.classes.EmployeTache;
import ma.projet.classes.EmployeTachePk;
import ma.projet.classes.Projet;
import ma.projet.classes.Tache;
import ma.projet.services.EmployeService;
import ma.projet.services.EmployeTacheService;
import ma.projet.services.ProjetService;
import ma.projet.services.TacheService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tajine
 */
public class TestsTachesParProjets {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        es.create(new Employe("Badr", "Ohlale", "0624091359"));
        es.create(new Employe("Yaakoub", "Laghdache", "0624542359"));
        ProjetService ps=new ProjetService();
        ps.create(new Projet("troll",new Date("11/11/2011"),new Date("12/12/2011"),es.getById(1)));
        ps.create(new Projet("troll2",new Date("09/09/2011"),new Date("10/10/2011"),es.getById(1)));
        ts.create(new Tache("test1", new Date("12/12/2020"), new Date("07/04/2021"), 154,ps.getById(1)));
        ts.create(new Tache("test2", new Date("11/11/2020"), new Date("06/05/2021"), 160,ps.getById(1)));
        ts.create(new Tache("test3", new Date("07/07/2020"), new Date("08/08/2021"), 1600,ps.getById(2)));
        EmployeTachePk pk=new EmployeTachePk(1,1);
        EmployeTachePk pk2=new EmployeTachePk(1,2);
        ets.create(new EmployeTache(pk,es.getById(1), ts.getById(1),new Date("11/07/2020"),new Date("10/04/2021")));
        ets.create(new EmployeTache(pk2,es.getById(1), ts.getById(2),new Date("11/07/2020"),new Date("10/04/2021")));
        for (Tache t : ps.getTachesByProjet(1)) {
            System.out.println(t);
        }
}
}
