package businessLogic;

import dao.ClientDAO;
import model.Client;

import java.util.List;
import java.util.stream.Collectors;

import static businessLogic.validators.ClientValidator.*;

/**
 * @Author: Calinescu Mirela
 * @Since: We just don't know...
 */
public class ClientBLL {

    private ClientDAO clientDAO;

    public ClientBLL() {
        this.clientDAO = new ClientDAO();
    }

    /**
     * displays all table entries in the GUI
     *
     * @return returns the list of clients
     */
    public List<Client> display() {
        return clientDAO.findAll();
    }

    /**
     * verifies if data is valid and tries to insert it
     *
     * @param name client name
     * @param password client password
     * @return returns a message for the user in the GUI
     */
    public String insert(String name, String password) {
        if(clientValidator(name, password)) {
            if(clientDAO.findAll().stream().filter(client -> client.getName().equals(name)).count() > 0)
                return "Client already exists.";
            if (clientDAO.insert(new Client(name, password)) == null)
                return "Client inserted.";

        }
        return "Wrong input.";
    }

    public Client findByName(String name) {
        return clientDAO.findByCategory(name, "name");
    }

    /**
     * verifies if data is valid and tries to delete it
     *
     * @param name client name
     * @return returns a message for the user in the GUI
     */
    public String deleteByName(String name) {
        if(clientNameValidator(name) == null)
            return "Wrong input.";
        if(clientDAO.findAll().stream().filter(client -> client.getName().equals(name)).count() > 0) {
            if (clientDAO.deleteByName("name", name) == null)
                return "Client deleted.";
        }
        return "Client not found.";
    }

    /**
     * verifies if data is valid and tries to delete it
     *
     * @param id client id
     * @return returns a message for the user in the GUI
     */
    public String deleteById(String id) {
        if(idValidator(id) == null)
            return "Wrong input.";
        if(clientDAO.findAll().stream().filter(client -> client.getId() == Integer.parseInt(id)).count() > 0) {
            if (clientDAO.deleteByID(id) == null)
                return "Client deleted.";
        }
        return "Client not found.";
    }

    /**
     * verifies if data is valid and tries to update it
     *
     * @param name1 name to update
     * @param name2 updated name
     * @param pass1 password to update
     * @param pass2 updated password
     * @return returns a message for the user in the GUI
     */
    public String update(String name1, String name2, String pass1, String pass2) {
        if(clientValidator(name1, pass1) && clientValidator(name2, pass2)) {
            if(clientDAO.findAll().stream().filter(client -> client.getName().equals(name1)).count() > 0) {
                Client client1 = new Client(name1, pass1);
                Client client2 = new Client(name2, pass2);
                if (clientDAO.update(client1, client2, "id, name, password") == null)
                    return "Client updated.";
            }
            return "Client not found.";
        }
        return "Wrong input.";
    }

}
