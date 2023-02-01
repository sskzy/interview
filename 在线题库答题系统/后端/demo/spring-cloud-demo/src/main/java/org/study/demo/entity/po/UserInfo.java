package org.study.demo.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @TableName tbl_user_info
 */
@TableName(value = "tbl_user_info")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    /**
     *
     */
    @TableId
    private String userId;

    /**
     *
     */
    private String userAccount;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String userAvatarUrl = "@/assets/userInfo/default_avatar.jpg";

    /**
     *
     */
    private String token;

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
        UserInfo other = (UserInfo) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUserAccount() == null ? other.getUserAccount() == null : this.getUserAccount().equals(other.getUserAccount()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getUserAvatarUrl() == null ? other.getUserAvatarUrl() == null : this.getUserAvatarUrl().equals(other.getUserAvatarUrl()))
                && (this.getToken() == null ? other.getToken() == null : this.getToken().equals(other.getToken()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserAccount() == null) ? 0 : getUserAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserAvatarUrl() == null) ? 0 : getUserAvatarUrl().hashCode());
        result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userAccount=").append(userAccount);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", userAvatarUrl=").append(userAvatarUrl);
        sb.append(", token=").append(token);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}