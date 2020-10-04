package link.lycreate.springbooteasyexceldemo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @ClassName LocalFile
 * @Description TODO $
 * @Author charlesYan
 * @Date 2020/9/27 18:43
 * @Version 1.0
 **/
public class LocalFile implements Serializable {

    @JsonProperty(value = "filePath")
    private String filePathStr;

    public String getFilePathStr() {
        return filePathStr;
    }

    public void setFilePathStr(String filePathStr) {
        this.filePathStr = filePathStr;
    }
}
