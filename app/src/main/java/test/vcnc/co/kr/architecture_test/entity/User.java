package test.vcnc.co.kr.architecture_test.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import test.vcnc.co.kr.architecture_test.model.Image;

@Entity
public class User {

    @PrimaryKey
    private String id;

    String name;

    @ColumnInfo(name = "created_time")
    private long createdTime;

    @ColumnInfo(name = "updated_time")
    private Long updatedTime;

    @Embedded(prefix = "image_")
    private Image image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
