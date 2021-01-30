package id.silvergen.adpro.web.screens.inbox;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Inbox;

@UiController("adpro_Inbox.edit")
@UiDescriptor("inbox-edit.xml")
@EditedEntityContainer("inboxDc")
@LoadDataBeforeShow
public class InboxEdit extends StandardEditor<Inbox> {
}