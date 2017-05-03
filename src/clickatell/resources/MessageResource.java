package clickatell.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;


import clickatell.model.*;
import clickatell.dao.*;

public class MessageResource 
{
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String from;
	
	public MessageResource(UriInfo uriInfo, Request request, String from)
	{
		this.uriInfo = uriInfo;
		this.request = request;
		this.from = from;
	}
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage()
	{
		Message message = MessageDao.instance.getModel().get(from);
		if(message==null)
			throw new RuntimeException("Get: Message from number " + from + " not found");
		
		return message;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessagee()
	{
		Message message = MessageDao.instance.getModel().get(from);
		if(message==null)
			throw new RuntimeException("Get: message from number " + from + " not found");
		
		return message;
	}
	
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public Message getMessageHTML()
	{
		Message message = MessageDao.instance.getModel().get(from);
		if(message==null)
			throw new RuntimeException("Get: Message from number " + from + " not found");
		
		return message;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putMessage(JAXBElement<Message> message)
	{
		Message c = message.getValue();
		return putAndGetResponse(c);
	}
	
	@DELETE
	public void deleteMessage()
	{
		Message c = MessageDao.instance.getModel().remove(from);
		if(c==null)
			throw new RuntimeException("Delete: Message from " + from + " not found");
	}
	
	private Response putAndGetResponse(Message message)
	{
		Response res;
		if(MessageDao.instance.getModel().containsKey(message.getMoMessageid()))
		{
			res = Response.noContent().build();
		}
		else
		{
			res = Response.created(uriInfo.getAbsolutePath()).build();
		}
		MessageDao.instance.getModel().put(message.getMoMessageid(), message);
		return res;
	}
	

}
