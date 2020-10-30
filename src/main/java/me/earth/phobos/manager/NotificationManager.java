// 
// Decompiled by Procyon v0.5.36
// 

package me.earth.phobos.manager;

import me.earth.phobos.Phobos;
import me.earth.phobos.features.modules.client.HUD;
import me.earth.phobos.features.notifications.Notifications;
import java.util.ArrayList;

public class NotificationManager
{
    private final ArrayList<Notifications> notifications;
    
    public NotificationManager() {
        this.notifications = new ArrayList<Notifications>();
    }
    
    public void handleNotifications(int posY) {
        for (int i = 0; i < this.getNotifications().size(); ++i) {
            this.getNotifications().get(i).onDraw(posY);
            posY -= Phobos.moduleManager.getModuleByClass(HUD.class).renderer.getFontHeight() + 5;
        }
    }
    
    public void addNotification(final String text, final long duration) {
        this.getNotifications().add(new Notifications(text, duration));
    }
    
    public ArrayList<Notifications> getNotifications() {
        return this.notifications;
    }
}
