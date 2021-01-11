package services;

import metier.Participant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

public class ParticipantService {

    private SessionFactory sessionFactory;

    public ParticipantService(SessionFactory sessionFactory){

    }

    public void create(String nom, String prenom, String email, Date dateNaissance, String organisation, List<String> observations) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(new Participant(nom,prenom,email,dateNaissance,organisation,observations));
        session.getTransaction().commit();
        session.close();
    }

}
