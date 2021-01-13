package id.silvergen.adpro.web.screens.province;

import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.Province;

@UiController("adpro_Province.browse")
@UiDescriptor("province-browse.xml")
@LookupComponent("provincesTable")
@LoadDataBeforeShow
public class ProvinceBrowse extends StandardLookup<Province> {
}