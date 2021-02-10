package id.silvergen.adpro.web.screens.institution;

import com.haulmont.chile.core.model.Instance;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import id.silvergen.adpro.entity.*;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

@UiController("adpro_Institution.edit")
@UiDescriptor("institution-edit.xml")
@EditedEntityContainer("institutionDc")
@LoadDataBeforeShow
public class InstitutionEdit extends StandardEditor<Institution> {
    @Inject
    private CollectionLoader<Regency> regenciesDl;
    @Inject
    private CollectionLoader<District> districtsDl;
    @Inject
    private CollectionLoader<Village> villagesDl;
    @Inject
    private LookupField regencyField;
    @Inject
    private LookupField districtField;
    @Inject
    private LookupField villageField;

    @Subscribe("provinceField")
    public void onProvinceFieldValueChange(HasValue.ValueChangeEvent<Province> event) {
        String provinceId = event.getValue().getId();
        if(provinceId != null){
            regenciesDl.setQuery("select e from adpro_Regency e where e.province.id = '" + provinceId + "'");
            regenciesDl.load();
            // filled value from db as default, change to first value of list if value selected from db changed
            if(regencyField.getValue()!=null)
                regencyField.setValue(regenciesDl.getContainer().getItems().get(0));
        }
    }

    @Subscribe("regencyField")
    public void onRegencyFieldValueChange(HasValue.ValueChangeEvent<Regency> event) {
        String regencyId = event.getValue().getId();
        if(regencyId != null){
            districtsDl.setQuery("select e from adpro_District e where e.regency.id = '" + regencyId + "'");
            districtsDl.load();
            // filled value from db as default, change to first value of list if value selected from db changed
            if(districtField.getValue()!=null)
                districtField.setValue(districtsDl.getContainer().getItems().get(0));
        }
    }

    @Subscribe("districtField")
    public void onDistrictFieldValueChange(HasValue.ValueChangeEvent<District> event) {
        String districtId = event.getValue().getId();
        if(districtId != null){
            villagesDl.setQuery("select e from adpro_Village e where e.district.id = '" + districtId + "'");
            villagesDl.load();
            // filled value from db as default, change to first value of list if value selected from db changed
            if(villageField.getValue()!=null)
                villageField.setValue(villagesDl.getContainer().getItems().get(0));
        }
    }
}