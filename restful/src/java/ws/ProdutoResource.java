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
import modelo.Produto;
import modelo.ProdutoDAO;

@Path("produto")
public class ProdutoResource {
    
    private ProdutoDAO dao;
    private Gson gson;
    
    public ProdutoResource() throws ClassNotFoundException, SQLException {
        dao = new ProdutoDAO();
        gson = new Gson();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insereProduto(String json) throws SQLException {
        Gson gson = new Gson();
        System.out.println(json);
        Produto c = gson.fromJson(json, Produto.class);
        dao.insert(c);
    }
    
    @DELETE
    @Path("{codigo}")
    public void deletaProduto(@PathParam("codigo") int codigo) throws SQLException {
        dao.delete(codigo);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editProduto(String json) throws SQLException {
        Gson gson = new Gson();
        System.out.println(json);
        Produto c = gson.fromJson(json, Produto.class);
        dao.edit(c);
    }
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String selecionaProduto() throws SQLException {
        ArrayList<Produto> list = dao.selectProduto();
        return gson.toJson(list);
    }
}
