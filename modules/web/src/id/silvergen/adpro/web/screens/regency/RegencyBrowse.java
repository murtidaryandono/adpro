package id.silvergen.adpro.web.screens.regency;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Regency;

@UiController("adpro_Regency.browse")
@UiDescriptor("regency-browse.xml")
@LookupComponent("regenciesTable")
@LoadDataBeforeShow
public class RegencyBrowse extends StandardLookup<Regency> {
}