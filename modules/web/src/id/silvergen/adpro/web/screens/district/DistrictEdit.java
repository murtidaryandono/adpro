package id.silvergen.adpro.web.screens.district;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.District;

@UiController("adpro_District.edit")
@UiDescriptor("district-edit.xml")
@EditedEntityContainer("districtDc")
@LoadDataBeforeShow
public class DistrictEdit extends StandardEditor<District> {
}