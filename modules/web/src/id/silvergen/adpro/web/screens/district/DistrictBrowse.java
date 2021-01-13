package id.silvergen.adpro.web.screens.district;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.District;

@UiController("adpro_District.browse")
@UiDescriptor("district-browse.xml")
@LookupComponent("districtsTable")
@LoadDataBeforeShow
public class DistrictBrowse extends StandardLookup<District> {
}