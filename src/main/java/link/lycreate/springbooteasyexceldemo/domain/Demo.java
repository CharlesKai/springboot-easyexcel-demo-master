package link.lycreate.springbooteasyexceldemo.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * demo
 * @author 
 */
@Data
public class Demo implements Serializable {

    @ExcelProperty("序号")
    private Integer demoId;

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("日期")
    @DateTimeFormat("yyyy/MM/dd")
    private Date demoData;

    @ExcelProperty("数字")
    private Integer dataNum;

    private static final long serialVersionUID = 1L;

    public Integer getDemoId() {
        return demoId;
    }

    public void setDemoId(Integer demoId) {
        this.demoId = demoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDemoData() {
        return demoData;
    }

    public void setDemoData(Date demoData) {
        this.demoData = demoData;
    }

    public Integer getDataNum() {
        return dataNum;
    }

    public void setDataNum(Integer dataNum) {
        this.dataNum = dataNum;
    }

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
        Demo other = (Demo) that;
        return (this.getDemoId() == null ? other.getDemoId() == null : this.getDemoId().equals(other.getDemoId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getDemoData() == null ? other.getDemoData() == null : this.getDemoData().equals(other.getDemoData()))
            && (this.getDataNum() == null ? other.getDataNum() == null : this.getDataNum().equals(other.getDataNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDemoId() == null) ? 0 : getDemoId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getDemoData() == null) ? 0 : getDemoData().hashCode());
        result = prime * result + ((getDataNum() == null) ? 0 : getDataNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", demoId=").append(demoId);
        sb.append(", title=").append(title);
        sb.append(", demoData=").append(demoData);
        sb.append(", dataNum=").append(dataNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}