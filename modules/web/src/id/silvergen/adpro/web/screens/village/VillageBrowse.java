package id.silvergen.adpro.web.screens.village;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Village;

@UiController("adpro_Village.browse")
@UiDescriptor("village-browse.xml")
@LookupComponent("villagesTable")
@LoadDataBeforeShow
public class VillageBrowse extends StandardLookup<Village> {
}