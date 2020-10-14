package link.lycreate.springbooteasyexceldemo.controller;

import com.alibaba.excel.EasyExcel;
import link.lycreate.springbooteasyexceldemo.dao.DemoDao;
import link.lycreate.springbooteasyexceldemo.domain.Demo;
import link.lycreate.springbooteasyexceldemo.domain.LocalFile;
import link.lycreate.springbooteasyexceldemo.listener.UploadDataListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * @Author charlesYan
     * @Description //接收前台传过来的文件
     * @Date 15:03 2020/10/13
     * @Param [file, model]
     * @return java.lang.String
     **/
    @RequestMapping(path="/upload",method = RequestMethod.POST)
    public String uploadExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        EasyExcel.read(file.getInputStream(), Demo.class,new UploadDataListener(demoDao)).sheet().doRead();
        return "/uploadStatus";
    }

    /**
     * @Author charlesYan
     * @Description //接收前台传过来的文件路径
     * @Date 14:57 2020/10/13
     * @Param [localFile]
     * @return java.lang.String
     **/
    @RequestMapping(path = "/read",method = RequestMethod.POST)
    public String readLocalExcel(@RequestBody LocalFile localFile){
        LOGGER.get().info("读取文件路径：{}",localFile.getFilePathStr());
        EasyExcel.read(localFile.getFilePathStr(),Demo.class,new UploadDataListener(demoDao)).sheet().doRead();
        LOGGER.get().info("读取文件成功！");
        return "/uploadStatus";
    }


    /**
     * @Author charlesYan
     * @Description //将数据导出到excel以文件路径形式返回
     * @Date 16:19 2020/10/13
     * @Param [targetFilePath]
     * @return java.lang.String
     **/
    @RequestMapping(path = "/write",method = RequestMethod.POST)
    public String writeExcel(@RequestParam("targetFilePath")String targetFilePath){
        LOGGER.get().info("写入文件路径：{}",targetFilePath);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        Demo demo = demoDao.selectByPrimaryKey(63);
        List<Demo> list = new ArrayList<Demo>();
        list.add(demo);
        EasyExcel.write(targetFilePath, Demo.class).sheet("模板").doWrite(list);
        return "/uploadStatus";
    }


    /**
     * @Author charlesYan
     * @Description //将数据导出到excel直接从web端返回
     * @Date 10:31 2020/10/14
     * @Param [response]
     * @return java.lang.String
     **/
    @GetMapping("/download")
    public void downloadExcel(HttpServletResponse response) throws IOException {
        LOGGER.get().info("web端下载文件");
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("202010141020测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        // 读取数据列表
        Demo demo = demoDao.selectByPrimaryKey(63);
        List<Demo> list = new ArrayList<Demo>();
        list.add(demo);
        EasyExcel.write(response.getOutputStream(), Demo.class).sheet("模板").doWrite(list);
    }


//    @LogFilter("保存请求日志")
    @RequestMapping(path = "/saveRequestLog",method = RequestMethod.GET)
    @ResponseBody
    public String saveRequestLog(@RequestParam("name")String name){
        LOGGER.get().info("保存请求日志");
        return "/uploadStatus";
    }
}
