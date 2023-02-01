package org.study.demo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_section_data
 */
@TableName(value ="tbl_section_data")
@Data
public class SectionData implements Serializable {
    /**
     * 
     */
    @TableId
    private String sectionId;

    /**
     * 
     */
    private String sectionVideoUrl;

    /**
     * 
     */
    private String sectionDetail;

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
        SectionData other = (SectionData) that;
        return (this.getSectionId() == null ? other.getSectionId() == null : this.getSectionId().equals(other.getSectionId()))
            && (this.getSectionVideoUrl() == null ? other.getSectionVideoUrl() == null : this.getSectionVideoUrl().equals(other.getSectionVideoUrl()))
            && (this.getSectionDetail() == null ? other.getSectionDetail() == null : this.getSectionDetail().equals(other.getSectionDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSectionId() == null) ? 0 : getSectionId().hashCode());
        result = prime * result + ((getSectionVideoUrl() == null) ? 0 : getSectionVideoUrl().hashCode());
        result = prime * result + ((getSectionDetail() == null) ? 0 : getSectionDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sectionId=").append(sectionId);
        sb.append(", sectionVideoUrl=").append(sectionVideoUrl);
        sb.append(", sectionDetail=").append(sectionDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}