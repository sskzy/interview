package org.study.demo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_lesson
 */
@TableName(value ="tbl_lesson")
@Data
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
            && (this.getLessonName() == null ? other.getLessonName() == null : this.getLessonName().equals(other.getLessonName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getLessonName() == null) ? 0 : getLessonName().hashCode());
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}