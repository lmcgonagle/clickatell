package clickatell.dao;

import java.util.HashMap;
import java.util.Map;



import clickatell.model.Message;

public enum MessageDao 
{
	instance;
	
	private Map<String, Message> contentProvider =new HashMap<>();
	
	private MessageDao()
	{
		Message message = new Message("3638052", "353861803058", "UTF-8", "%05%00%03%0a%02%02");
        message.setMoMessageid("abcdef1234567890abcdef1234567890");
        message.setFrom("447732116878");
        message.setTimestamp("2014-07-30 15:57:03");
        message.setText("Test message");
        contentProvider.put(message.getMoMessageid(), message);
        message = new Message("3638052", "353861803058", "UTF-8", "%05%00%03%0a%02%02");
        message.setMoMessageid("abcdef1234567890abcdef1234567891");
        message.setFrom("447732116878");
        message.setTimestamp("2014-07-31 15:57:03");
        message.setText("Test message number 2");
        contentProvider.put(message.getMoMessageid(), message);
	}
	
	
	public Map<String, Message> getModel()
	{
		return contentProvider;
	}
}
