package org.study.demo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_section
 */
@TableName(value ="tbl_section")
@Data
public class Section implements Serializable {
    /**
     * 
     */
    @TableId
    private String sectionId;

    /**
     * 
     */
    private String lessonId;

    /**
     * 
     */
    private String sectionName;

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
        Section other = (Section) that;
        return (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
            && (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getSectionName() == null ? other.getSectionName() == null : this.getSectionName().equals(other.getSectionName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getSectionName() == null) ? 0 : getSectionName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sectionId=").append(sectionId);
        sb.append(", lessonId=").append(lessonId);
        sb.append(", sectionName=").append(sectionName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}