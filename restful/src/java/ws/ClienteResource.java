package ws;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Cliente;
import modelo.ClienteDAO;

@Path("cliente")
public class ClienteResource {
    
    private ClienteDAO dao;
    private Gson gson;

    public ClienteResource() throws ClassNotFoundException, SQLException {
       dao = new ClienteDAO();
       gson = new Gson();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insereCliente(String json) throws SQLException {
        Gson gson = new Gson();
        System.out.println(json);
        Cliente c = gson.fromJson(json, Cliente.class);
        dao.insert(c);
    }
    
    @DELETE
    @Path("{id}")
    public void deletaCliente(@PathParam("id") int id) throws SQLException {
        dao.delete(id);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCliente(String json) throws SQLException {
        Gson gson = new Gson();
        System.out.println(json);
        Cliente c = gson.fromJson(json, Cliente.class);
        dao.edit(c);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionaCliente() throws SQLException {
        ArrayList<Cliente> list = dao.selectCliente();
        return gson.toJson(list);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String selecionaCliente(@PathParam("id") int id) throws SQLException {
        return gson.toJson(dao.selectCliente(id));
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user}/{password}")
    public String selecionaCliente(@PathParam("user") String user, @PathParam("password") String password) throws SQLException {
        return gson.toJson(dao.selectCliente(user, password));
    }
}
