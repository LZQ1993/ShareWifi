package aeric.sharewifi.bean;

/**
 * Created by ${Lizhiq} on 2017/11/1.
 */

public class Areas {
    private int id;
    private int pid;
    private int level;
    private String name;
    private String createTime;
    private String updateTime;
    private boolean deleted;
    private String childrenCount;

    public void setId(int id) {
        this.id = id;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setChildrenCount(String childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getId() {
        return id;
    }

    public int getPid() {
        return pid;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getChildrenCount() {
        return childrenCount;
    }
}
