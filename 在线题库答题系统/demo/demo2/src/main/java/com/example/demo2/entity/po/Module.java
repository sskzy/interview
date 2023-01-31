package com.example.demo2.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_module
 */
@TableName(value ="tbl_module")
@Data
public class Module implements Serializable {
    /**
     * 
     */
    @TableId
    private String moduleId;

    /**
     * 
     */
    private String lessonId;

    /**
     * 
     */
    private String moduleName;

    /**
     * 
     */
    private String lessonVideoUrl;

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
        Module other = (Module) that;
        return (this.getModuleId() == null ? other.getModuleId() == null : this.getModuleId().equals(other.getModuleId()))
            && (this.getLessonId() == null ? other.getLessonId() == null : this.getLessonId().equals(other.getLessonId()))
            && (this.getModuleName() == null ? other.getModuleName() == null : this.getModuleName().equals(other.getModuleName()))
            && (this.getLessonVideoUrl() == null ? other.getLessonVideoUrl() == null : this.getLessonVideoUrl().equals(other.getLessonVideoUrl()))
            && (this.getLessonDetail() == null ? other.getLessonDetail() == null : this.getLessonDetail().equals(other.getLessonDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getModuleId() == null) ? 0 : getModuleId().hashCode());
        result = prime * result + ((getLessonId() == null) ? 0 : getLessonId().hashCode());
        result = prime * result + ((getModuleName() == null) ? 0 : getModuleName().hashCode());
        result = prime * result + ((getLessonVideoUrl() == null) ? 0 : getLessonVideoUrl().hashCode());
        result = prime * result + ((getLessonDetail() == null) ? 0 : getLessonDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moduleId=").append(moduleId);
        sb.append(", lessonId=").append(lessonId);
        sb.append(", moduleName=").append(moduleName);
        sb.append(", lessonVideoUrl=").append(lessonVideoUrl);
        sb.append(", lessonDetail=").append(lessonDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}