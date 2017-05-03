package clickatell.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message 
{
	private String apiId;
	private String moMessageid;
	private String from;
	private String to;
	private String timestamp;
	private String charset;
	private String udh;
	private String text;
	
	public Message()
	{
		
	}

	public Message(String apiId, String to, String charset,
			String udh) 
	{
		
		this.apiId = apiId;
		this.to = to;
		this.charset = charset;
		this.udh = udh;
		
	}

	public String getApiId() 
	{
		return apiId;
	}

	public void setApiId(String apiId) 
	{
		this.apiId = apiId;
	}

	public String getMoMessageid() 
	{
		return moMessageid;
	}

	public void setMoMessageid(String moMessageid) 
	{
		this.moMessageid = moMessageid;
	}

	public String getFrom() 
	{
		return from;
	}

	public void setFrom(String from) 
	{
		this.from = from;
	}

	public String getTo() 
	{
		return to;
	}

	public void setTo(String to) 
	{
		this.to = to;
	}

	public String getTimestamp() 
	{
		return timestamp;
	}

	public void setTimestamp(String timestamp) 
	{
		this.timestamp = timestamp;
	}

	public String getCharset() 
	{
		return charset;
	}

	public void setCharset(String charset) 
	{
		this.charset = charset;
	}

	public String getUdh() 
	{
		return udh;
	}

	public void setUdh(String udh) 
	{
		this.udh = udh;
	}

	public String getText() 
	{
		return text;
	}

	public void setText(String text) 
	{
		this.text = text;
	}
	
	public void toPrint()
	{
		System.out.print(this.toString());
	}
	
	
	
	
	
}
