package id.silvergen.adpro.web.screens.village;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Village;

@UiController("adpro_Village.edit")
@UiDescriptor("village-edit.xml")
@EditedEntityContainer("villageDc")
@LoadDataBeforeShow
public class VillageEdit extends StandardEditor<Village> {
}