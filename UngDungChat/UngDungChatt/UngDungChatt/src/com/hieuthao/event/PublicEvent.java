
package com.hieuthao.event;

/**
 *
 * @author MinhHieu
 */
public class PublicEvent {
    
   private static PublicEvent instance;
   private EventMain eventMain;
   private EventImageView eventImageView;
   private EventChat eventChat;
   private EventLogin eventLogin;
   private Event_menuLeft evenMenuLeft;
   
   
    public static PublicEvent getInstance() {
        if (instance == null) {
            instance = new PublicEvent();
        }
        return instance;
    }

    private PublicEvent() {

    }
    
    public void addEventMain(EventMain event){
        this.eventMain = event;
    }
    
    public EventMain getEventMain(){
        return eventMain;
    }

    public void addEventImageView(EventImageView event) {
        this.eventImageView = event;
    }

    public EventImageView getEventImageView() {
        return eventImageView;
    }
    
    public void addEventChat(EventChat event){
        this.eventChat = event;
    }
    
    public EventChat getEventChat(){
        return eventChat;
    }
    
    public void addEventLogin(EventLogin event){
        this.eventLogin = event;
    }
    
    public EventLogin getEventLogin(){
        return eventLogin;
    }
    
    public void addEventMenuLeft(Event_menuLeft event){
        this.evenMenuLeft = event;
    }
    
    public Event_menuLeft getEvent_menuLeft(){
        return evenMenuLeft;
    }
}
