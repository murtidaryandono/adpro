package id.silvergen.adpro.web.screens.mainscreen;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.gui.components.mainwindow.SideMenu;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.web.app.main.MainScreen;
import id.silvergen.adpro.entity.Inbox;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Inject
    private SideMenu sideMenu;
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionLoader<Inbox> inboxesDl;
    private User userLoggedIn;

    @Inject
    private Notifications notifications;

    @Subscribe("inboxTimer")
    private void onTimer(Timer.TimerActionEvent event) {
        // set count on inbox menu badge
        sideMenu.getMenuItem("inbox").setBadgeText(String.valueOf(getInboxCount()));

        // show new notification only
        List<Inbox> inboxNotification = getInboxNotificationList();
        Iterator i = inboxNotification.listIterator();
        while(i.hasNext()){
            Inbox inbox = (Inbox) i.next();
            notifications.create(Notifications.NotificationType.TRAY)
                    .withDescription(inbox.getMessage())
                    .withCaption(inbox.getTitle())
                    .show();
            // set notification flag to true, so notification won't show again
            inbox.setNotificationStatus(true);
        }
        // commit update notification list to be saved on database
        CommitContext commitContext = new CommitContext(inboxNotification);
        dataManager.commit(commitContext);
    }

    @Subscribe
    public void onInit(InitEvent event) {
        sideMenu.getMenuItem("reports").setIcon("font-icon:FILE");
        sideMenu.getMenuItem("tenant-management").setIcon("font-icon:HOME");
        sideMenu.getMenuItem("dashboard").setIcon("font-icon:DASHBOARD");
        sideMenu.getMenuItem("administration").setIcon("font-icon:TABLE");
        sideMenu.getMenuItem("help").setIcon("font-icon:HEADPHONES");
        sideMenu.getMenuItem("inbox").setBadgeText(String.valueOf(getInboxCount()));
    }

    private Long getInboxCount(){
        UserSessionSource uss = AppBeans.get(UserSessionSource.class);
        userLoggedIn = uss.getUserSession().getUser();
        Long count = new Long(0);
        if (userLoggedIn == null)
            throw new IllegalStateException("user logged in parameter is null");
        if (userLoggedIn.getGroup().getName().equals("Root") || userLoggedIn.getGroup().getName().equals("Admin"))
            count = dataManager.loadValue("select count(e) from adpro_Inbox e where e.readStatus = false",
                    Long.class).one();
        else
            count = dataManager.loadValue("select count(e) from adpro_Inbox e where " +
                            "(e.user.group.name = 'All' or e.user.name = '" + userLoggedIn.getName() + "') and " +
                            "e.readStatus = false",
                    Long.class).one();
        return count;
    }

    private List<Inbox> getInboxNotificationList(){
        UserSessionSource uss = AppBeans.get(UserSessionSource.class);
        userLoggedIn = uss.getUserSession().getUser();
        List<Inbox> result = new ArrayList<>();
        if (userLoggedIn == null)
            throw new IllegalStateException("user logged in parameter is null");
        if (userLoggedIn.getGroup().getName().equals("Root") || userLoggedIn.getGroup().getName().equals("Admin"))
            result = dataManager.load(Inbox.class)
                    .query("select e from adpro_Inbox e where e.readStatus = false " +
                            "and e.notificationStatus = false")
                    .list();
        else
            result = dataManager.load(Inbox.class)
                    .query("select e from adpro_Inbox e where " +
                            "(e.user.group.name = 'All' or e.user.name = '" + userLoggedIn.getName() + "') and " +
                            "e.readStatus = false and e.notificationStatus = false")
                    .list();
        return result;
    }
}