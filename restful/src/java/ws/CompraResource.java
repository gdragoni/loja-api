package ws;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Compra;
import modelo.CompraDAO;

@Path("compra")
public class CompraResource {
    
    private CompraDAO dao;
    private Gson gson;

    public CompraResource() throws ClassNotFoundException, SQLException {
        dao = new CompraDAO();
        gson = new Gson();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insereCompra(String json) throws SQLException {
        System.out.println(json);
        Compra c = gson.fromJson(json, Compra.class);
        dao.insert(c);
    }
    
    @DELETE
    @Path("{id}")
    public void deletaCompra(@PathParam("id") int id) throws SQLException {
        dao.delete(id);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editCompra(String json) throws SQLException {
        Gson gson = new Gson();
        System.out.println(json);
        Compra c = gson.fromJson(json, Compra.class);
        dao.edit(c);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionaCompra() throws SQLException {
        ArrayList<Compra> list = dao.selectCompra();
        return gson.toJson(list);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{date}")
    public String selecionaCompra(@PathParam("date") String date) throws SQLException {
        ArrayList<Compra> list = dao.selectCompra(date);
        return gson.toJson(list);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{beforeDate}/{afterDate}")
    public String selecionaCompra(@PathParam("beforeDate") String beforeDate, @PathParam("afterDate") String afterDate) throws SQLException {
        ArrayList<Compra> list = dao.selectCompra(beforeDate, afterDate);
        return gson.toJson(list);
    }
}
