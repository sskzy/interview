package org.study.demo.entity.po;

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
 * @TableName tbl_completed
 */
@TableName(value ="tbl_completed")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Completed implements Serializable {
    /**
     * 
     */
    @TableId
    private String completedId;

    /**
     * 
     */
    private String userId;

    /**
     * 
     */
    private String lessonId;

    /**
     * 
     */
    private String sectionId;

    /**
     * 
     */
    private Boolean iscompleted;

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
        Completed other = (Completed) that;
        return (this.getCompletedId() == null ? other.getCompletedId() == null : this.getCompletedId().equals(other.getCompletedId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
            && (this.getIscompleted() == null ? other.getIscompleted() == null : this.getIscompleted().equals(other.getIscompleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCompletedId() == null) ? 0 : getCompletedId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getIscompleted() == null) ? 0 : getIscompleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", completedId=").append(completedId);
        sb.append(", userId=").append(userId);
        sb.append(", lessonId=").append(lessonId);
        sb.append(", sectionId=").append(sectionId);
        sb.append(", iscompleted=").append(iscompleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}