package link.lycreate.springbooteasyexceldemo;

import com.alibaba.excel.EasyExcel;
import link.lycreate.springbooteasyexceldemo.dao.DemoDao;
import link.lycreate.springbooteasyexceldemo.domain.Demo;
import link.lycreate.springbooteasyexceldemo.listener.UploadDataListener;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @ClassName ExcelDemo
 * @Description TODO
 * @Author LYcreate
 * @Date 2020/5/1 17:29
 */
public class ExcelDemo extends SpringbootEasyexcelDemoApplicationTests{
    @Test
    public void excelTest(){
    }

    @Resource
    private DemoDao demoDao;

    @Test
    public void simpleRead(){
        System.out.println("测试解析指定路径下excel开始");
        String filePath = "E:\\Blog\\工作簿1.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(filePath, Demo.class,new UploadDataListener(demoDao)).sheet().doRead();
        System.out.println("测试解析指定路径下excel结束");
    }

    @Test
    public void testPostman(){
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "");
//        Request request = new Request.Builder()
//                .url("http://localhost:8080/saveRequestLog?name=wangwu")
//                .method("POST", body)
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Cookie", "JSESSIONID=ECFC51F91CC6FD9F486AC2B253A72222")
//                .build();
//        Response response = client.newCall(request).execute();
    }
}
