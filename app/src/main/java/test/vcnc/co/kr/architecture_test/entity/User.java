package test.vcnc.co.kr.architecture_test.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;

import test.vcnc.co.kr.architecture_test.model.Image;

@Entity(indices = {@Index(value = "id", unique = true)}, foreignKeys = {
        @ForeignKey(entity = Book.class, parentColumns = "id", childColumns = "bookId", onDelete = ForeignKey.CASCADE)
})
public class User {

    @PrimaryKey(autoGenerate = true)
    private Long id;

    String name;

    @ColumnInfo(name = "created_time")
    private long createdTime;

    @ColumnInfo(name = "updated_time")
    private Long updatedTime;

    @Embedded(prefix = "image_")
    private Image image;

    private int age;

    public Long bookId;

    @Ignore
    Bitmap profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bitmap getProfile() {
        return profile;
    }

    public void setProfile(Bitmap profile) {
        this.profile = profile;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
