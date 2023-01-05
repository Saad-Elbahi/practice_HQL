
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
public class TachePrixSup {
    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        TacheService ts = new TacheService();
        EmployeTacheService ets = new EmployeTacheService();
        es.create(new Employe("saad", "elbahi", "1234568895"));
        es.create(new Employe("said", "bnbr", "44556624"));
        ProjetService ps=new ProjetService();
        ps.create(new Projet("troll",new Date("11/12/2015"),new Date("13/12/2011"),es.getById(1)));
        ps.create(new Projet("troll2",new Date("09/09/2010"),new Date("10/10/2009"),es.getById(1)));
        ts.create(new Tache("tache1", new Date("12/12/2022"), new Date("07/04/2022"), 154,ps.getById(1)));
        ts.create(new Tache("tache2", new Date("11/11/2022"), new Date("06/05/2022"), 160,ps.getById(1)));
        ts.create(new Tache("tache3", new Date("07/07/2023"), new Date("08/08/2023"), 1600,ps.getById(2)));
        EmployeTachePk pk=new EmployeTachePk(1,1);
        EmployeTachePk pk2=new EmployeTachePk(1,2);
        ets.create(new EmployeTache(pk,es.getById(1), ts.getById(1),new Date("11/07/2020"),new Date("10/04/2023")));
        ets.create(new EmployeTache(pk2,es.getById(1), ts.getById(2),new Date("11/07/2020"),new Date("10/04/2023")));
        for (Tache t : ts.prixSup(1000)) {
            System.out.println(t);

}
}
}
