package clickatell.resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.vogella.jersey.todo.model.Todo;

import ccom.vogella.jersey.todo.dao.TodoDao;
import clickatell.dao.MessageDao;
import clickatell.model.Message;





@Path("/messages")
public class MessagesResource 
{
	 @Context
     UriInfo uriInfo;
     @Context
     Request request;

    
     @GET
     @Produces(MediaType.TEXT_XML)
     public List<Message> getMessageBrowser() {
             List<Message> messages = new ArrayList<Message>();
             messages.addAll(MessageDao.instance.getModel().values());
             return messages;
     }
     
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public List<Message> getMessagess() {
             List<Message> messages = new ArrayList<Message>();
             messages.addAll(MessageDao.instance.getModel().values());
             return messages;
     }

     
     @GET
     @Produces(MediaType.APPLICATION_XML)
     public List<Message> getMessages() {
             List<Message> messages = new ArrayList<Message>();
             messages.addAll(MessageDao.instance.getModel().values());
             return messages;
     }

    
     @GET
     @Path("count")
     @Produces(MediaType.TEXT_PLAIN)
     public String getCount() {
             int count = MessageDao.instance.getModel().size();
             return String.valueOf(count);
     }

     @POST
     @Produces(MediaType.TEXT_HTML)
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     public void newMessage(@FormParam("apiId") String apiId,
                     @FormParam("moMessageid") String moMessageid,
                     @FormParam("from") String from,
                     @FormParam("to") String to,
                     @FormParam("timestamp") String timestamp,
                     @FormParam("charset") String charset,
                     @FormParam("udh") String udh,
                     @FormParam("text") String text,
                     @Context HttpServletResponse servletResponse) throws IOException {
             Message message = new Message(apiId, to, charset, udh);
             message.setmMessageid(description);
             }
             TodoDao.instance.getModel().put(id, todo);

             servletResponse.sendRedirect("../create_todo.html");
     }

     // Defines that the next path parameter after todos is
     // treated as a parameter and passed to the TodoResources
     // Allows to type http://localhost:8080/com.vogella.jersey.todo/rest/todos/1
     // 1 will be treaded as parameter todo and passed to TodoResource
     @Path("{message}")
     public MessageResource getTodo(@PathParam("message") String from) {
             return new MessageResource(uriInfo, request, from);
     }

}
