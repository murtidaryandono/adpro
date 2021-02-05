package id.silvergen.adpro.entity;

import com.haulmont.addon.sdbmt.entity.TenantUser;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.*;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "ADPRO_INBOX", indexes = {
        @Index(name = "IDX_ADPRO_INBOX", columnList = "TITLE, MESSAGE, USER_ID")
})
@Entity(name = "adpro_Inbox")
@NamePattern("%s|title")
public class Inbox extends BaseLongIdEntity implements Creatable, Updatable, SoftDelete, Versioned {
    private static final long serialVersionUID = 7948862218850749102L;

    @NotNull
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotNull
    @Column(name = "MESSAGE", nullable = false, length = 1028)
    private String message;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    private TenantUser user;

    @NotNull
    @Column(name = "READ_STATUS", nullable = false)
    private Boolean readStatus = false;

    @NotNull
    @Column(name = "NOTIFICATION_STATUS", nullable = false)
    private Boolean notificationStatus = false;

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

    public Boolean getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(Boolean notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }

    public TenantUser getUser() {
        return user;
    }

    public void setUser(TenantUser user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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