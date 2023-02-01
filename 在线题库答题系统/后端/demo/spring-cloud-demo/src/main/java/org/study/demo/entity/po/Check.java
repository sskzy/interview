package org.study.demo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tbl_check
 */
@TableName(value ="tbl_check")
@Data
public class Check implements Serializable {
    /**
     * 
     */
    @TableId
    private String checkId;

    /**
     * 
     */
    private String questionId;

    /**
     * 
     */
    private String checkChoose;

    /**
     * 
     */
    private Boolean checkFlag;

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
        Check other = (Check) that;
        return (this.getCheckId() == null ? other.getCheckId() == null : this.getCheckId().equals(other.getCheckId()))
            && (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getCheckChoose() == null ? other.getCheckChoose() == null : this.getCheckChoose().equals(other.getCheckChoose()))
            && (this.getCheckFlag() == null ? other.getCheckFlag() == null : this.getCheckFlag().equals(other.getCheckFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCheckId() == null) ? 0 : getCheckId().hashCode());
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getCheckChoose() == null) ? 0 : getCheckChoose().hashCode());
        result = prime * result + ((getCheckFlag() == null) ? 0 : getCheckFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkId=").append(checkId);
        sb.append(", questionId=").append(questionId);
        sb.append(", checkChoose=").append(checkChoose);
        sb.append(", checkFlag=").append(checkFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}