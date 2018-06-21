package Chat;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import beans.userController;

@ApplicationScoped
@ServerEndpoint("/chatroomEndPoint")
public class ChatroomEndPoint{
	static int userID = 0;
	static Set<Session> chatroomUsers = new HashSet<Session>();
	
	@OnOpen
	public void handleOpen(Session userSession) {
		chatroomUsers.add(userSession);
		/*String username = (String) userSession.getUserProperties().get("username");
		if(username == null) {
			userSession.getUserProperties().put("username", "pepe" + userID);
			userID++;
		}*/
	}
	
	@OnClose
	public void handleClose(Session userSession) {
		chatroomUsers.remove(userSession);
	}
	
	@OnMessage
	public void handleMessage(String message, Session userSession) {
		String username = (String) userSession.getUserProperties().get("username");
		if(username == null) {
			userSession.getUserProperties().put("username", message);
		}
		else {
			Iterator<Session> iterator = chatroomUsers.iterator();
			while(iterator.hasNext()) {
				try {
					iterator.next().getBasicRemote().sendText(username + ": "+ message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}

	}
	

	@OnError
    public void onError(Throwable e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
