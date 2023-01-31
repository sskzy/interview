package com.example.demo1.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tbl_lesson
 */
@TableName(value ="tbl_lesson")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson implements Serializable {
    /**
     * 
     */
    @TableId
    private String lessonId;

    /**
     * 
     */
    private String lessonName;

    /**
     * 
     */
    private String lessonImgUrl;

    /**
     * 
     */
    private String lessonDetail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Lesson other = (Lesson) that;
        return (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getLessonName() == null ? other.getLessonName() == null : this.getLessonName().equals(other.getLessonName()))
            && (this.getLessonImgUrl() == null ? other.getLessonImgUrl() == null : this.getLessonImgUrl().equals(other.getLessonImgUrl()))
            && (this.getLessonDetail() == null ? other.getLessonDetail() == null : this.getLessonDetail().equals(other.getLessonDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getLessonName() == null) ? 0 : getLessonName().hashCode());
        result = prime * result + ((getLessonImgUrl() == null) ? 0 : getLessonImgUrl().hashCode());
        result = prime * result + ((getLessonDetail() == null) ? 0 : getLessonDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lessonId=").append(lessonId);
        sb.append(", lessonName=").append(lessonName);
        sb.append(", lessonImgUrl=").append(lessonImgUrl);
        sb.append(", lessonDetail=").append(lessonDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}