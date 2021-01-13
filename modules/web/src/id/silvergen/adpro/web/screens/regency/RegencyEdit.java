package id.silvergen.adpro.web.screens.regency;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Regency;

@UiController("adpro_Regency.edit")
@UiDescriptor("regency-edit.xml")
@EditedEntityContainer("regencyDc")
@LoadDataBeforeShow
public class RegencyEdit extends StandardEditor<Regency> {
}