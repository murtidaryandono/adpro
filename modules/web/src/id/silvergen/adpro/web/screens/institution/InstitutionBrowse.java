package id.silvergen.adpro.web.screens.institution;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Institution;

@UiController("adpro_Institution.browse")
@UiDescriptor("institution-browse.xml")
@LookupComponent("institutionsTable")
@LoadDataBeforeShow
public class InstitutionBrowse extends StandardLookup<Institution> {
}