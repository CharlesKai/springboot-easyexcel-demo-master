package link.lycreate.springbooteasyexceldemo.controller;

import com.alibaba.excel.EasyExcel;
import link.lycreate.springbooteasyexceldemo.aspect.LogFilter;
import link.lycreate.springbooteasyexceldemo.dao.DemoDao;
import link.lycreate.springbooteasyexceldemo.domain.Demo;
import link.lycreate.springbooteasyexceldemo.domain.LocalFile;
import link.lycreate.springbooteasyexceldemo.listener.UploadDataListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @ClassName ExcelDemoController
 * @Description TODO
 * @Author LYcreate
 * @Date 2020/5/1 17:40
 */
@Controller
public class ExcelDemoController {

    private final ThreadLocal<Logger> LOGGER = ThreadLocal.withInitial(() -> LoggerFactory.getLogger(ExcelDemoController.class));

    @Resource
    private DemoDao demoDao;

    @RequestMapping(path="/upload",method = RequestMethod.POST)
    public String uploadExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        EasyExcel.read(file.getInputStream(), Demo.class,new UploadDataListener(demoDao)).sheet().doRead();
        return "/uploadStatus";
    }

    @RequestMapping(path = "/read",method = RequestMethod.POST)
    public String readLocalExcel(@RequestBody LocalFile localFile){
        LOGGER.get().info("读取文件路径：{}",localFile.getFilePathStr());
        EasyExcel.read(localFile.getFilePathStr(),Demo.class,new UploadDataListener(demoDao)).sheet().doRead();
        LOGGER.get().info("读取文件成功！");
        return "/uploadStatus";
    }

    @LogFilter("保存请求日志")
    @RequestMapping(path = "/saveRequestLog",method = RequestMethod.POST)
    public String saveRequestLog(@RequestParam("name")String name){
        return "请求成功：" + name;
    }
}
