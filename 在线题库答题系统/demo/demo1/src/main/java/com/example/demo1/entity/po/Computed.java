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
 * @TableName tbl_computed
 */
@TableName(value ="tbl_computed")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computed implements Serializable {
    /**
     * 
     */
    @TableId
    private String computedId;

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
    private String moduleId;

    /**
     * 
     */
    private Boolean isFinish;

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
        Computed other = (Computed) that;
        return (this.getComputedId() == null ? other.getComputedId() == null : this.getComputedId().equals(other.getComputedId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getIsFinish() == null ? other.getIsFinish() == null : this.getIsFinish().equals(other.getIsFinish()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getComputedId() == null) ? 0 : getComputedId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getIsFinish() == null) ? 0 : getIsFinish().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", computedId=").append(computedId);
        sb.append(", userId=").append(userId);
        sb.append(", lessonId=").append(lessonId);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", isFinish=").append(isFinish);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}