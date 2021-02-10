package id.silvergen.adpro.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.*;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "ADPRO_INSTITUTION")
@Entity(name = "adpro_Institution")
@NamePattern("%s|name")
public class Institution extends BaseLongIdEntity implements Creatable, Updatable, SoftDelete, Versioned {
    private static final long serialVersionUID = 5798810912462335589L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 1024)
    private String description;

    @NotNull
    @Column(name = "ADDRESS", nullable = false, length = 1024)
    private String address;

    @Column(name = "ADDRESS_ADDITIONAL", length = 1024)
    private String addressAdditional;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @JoinColumn(name = "PROVINCE_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Province province;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @JoinColumn(name = "REGENCY_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Regency regency;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @JoinColumn(name = "DISTRICT_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private District district;

    @Lookup(type = LookupType.DROPDOWN, actions = "lookup")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "VILLAGE_ID")
    private Village village;

    @Column(name = "CREATE_TS")
    private Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    private String createdBy;

    @Column(name = "UPDATE_TS")
    private Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    private String updatedBy;

    @Column(name = "DELETE_TS")
    private Date deleteTs;

    @Column(name = "DELETED_BY", length = 50)
    private String deletedBy;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Regency getRegency() {
        return regency;
    }

    public void setRegency(Regency regency) {
        this.regency = regency;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public String getAddressAdditional() {
        return addressAdditional;
    }

    public void setAddressAdditional(String addressAdditional) {
        this.addressAdditional = addressAdditional;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getVersion() {
        return version;
    }

    @Override
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public Boolean isDeleted() {
        return deleteTs != null;
    }

    @Override
    public String getDeletedBy() {
        return deletedBy;
    }

    @Override
    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    @Override
    public Date getDeleteTs() {
        return deleteTs;
    }

    @Override
    public void setDeleteTs(Date deleteTs) {
        this.deleteTs = deleteTs;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

}