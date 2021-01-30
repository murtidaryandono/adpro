package id.silvergen.adpro.web.screens.inbox;

import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;
import id.silvergen.adpro.entity.Inbox;

import javax.inject.Inject;

@UiController("adpro_Inbox.browse")
@UiDescriptor("inbox-browse.xml")
@LookupComponent("inboxesTable")
@LoadDataBeforeShow
public class InboxBrowse extends StandardLookup<Inbox> {

    @Inject
    private CollectionLoader<Inbox> inboxesDl;
    private User userLoggedIn;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        UserSessionSource uss = AppBeans.get(UserSessionSource.class);
        userLoggedIn = uss.getUserSession().getUser();
        if (userLoggedIn == null)
            throw new IllegalStateException("user logged in parameter is null");
        if (userLoggedIn.getGroup().getName().equals("Root") || userLoggedIn.getGroup().getName().equals("Admin") )
            inboxesDl.setQuery("select e from adpro_Inbox e");
        else
            inboxesDl.setQuery("select e from adpro_Inbox e where e.user.group.name = 'All' or e.user.name = '" + userLoggedIn.getName() +"'");
        inboxesDl.load();
    }
}