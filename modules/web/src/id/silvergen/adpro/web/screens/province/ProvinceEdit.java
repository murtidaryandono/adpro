package id.silvergen.adpro.web.screens.province;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Province;

@UiController("adpro_Province.edit")
@UiDescriptor("province-edit.xml")
@EditedEntityContainer("provinceDc")
@LoadDataBeforeShow
public class ProvinceEdit extends StandardEditor<Province> {
}