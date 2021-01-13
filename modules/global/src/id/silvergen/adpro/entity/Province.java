package id.silvergen.adpro.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Table(name = "ADPRO_PROVINCE", indexes = {
        @Index(name = "IDX_ADPRO_PROVINCE", columnList = "NAME")
})
@Entity(name = "adpro_Province")
@NamePattern("%s|name")
public class Province extends BaseStringIdEntity implements Creatable, Updatable, SoftDelete, Versioned {
    private static final long serialVersionUID = -4674697357172122593L;

    @Id
    @Column(name = "ID", nullable = false, length = 2)
    private String id;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

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

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}