/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.aor.projeto7.grupoc.entities.Client;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.NotRegistedEmailException;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.PasswordException;
import pt.uc.dei.aor.projeto7.grupoc.utilities.EncriptMD5;

/**
 *
 * @author User
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "GrossistaWebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    public Client getUserbyEmail(String email) throws NotRegistedEmailException {
        Query q = em.createNamedQuery("Client.findByClientEmail");
        q.setParameter("email", email);
        try {
            Client user = (Client) q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            throw new NotRegistedEmailException();
        }
    }

    public Client searchLogged(String email, String password) throws NotRegistedEmailException, PasswordException {
        Client usertemp = getUserbyEmail(email);
        String passEncripted = EncriptMD5.cryptWithMD5(password);
        if (usertemp != null && !usertemp.getApiKEY().equals(passEncripted)) {
            throw new PasswordException();
        } else if (usertemp == null) {
            throw new NotRegistedEmailException();
        } else {
            return usertemp;
        }
    }

    public Client findClientByApiKey(String apiKey) throws UserNotFoundException {
        try {
            return (Client) em.createNamedQuery("Client.findByApiKey")
                    .setParameter("apiKEY", apiKey).getSingleResult();
        } catch (NoResultException ex) {
            throw new UserNotFoundException();
        }
    }

}
