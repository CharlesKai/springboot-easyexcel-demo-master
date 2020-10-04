package link.lycreate.springbooteasyexceldemo.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import link.lycreate.springbooteasyexceldemo.dao.DemoDao;
import link.lycreate.springbooteasyexceldemo.domain.Demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UploadDataListener
 * @Description  有个很重要的点 UploadDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
 * @Author LYcreate
 * @Date 2020/5/1 17:49
 */
public class UploadDataListener extends AnalysisEventListener<Demo> {

    private Logger LOGGER= LoggerFactory.getLogger(this.getClass());

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    List<Demo> list=new ArrayList<Demo>();

    /**
     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
     */
    private DemoDao demoDao;


    public UploadDataListener(DemoDao demoDao){
        this.demoDao=demoDao;
    }


    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(Demo demo, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(demo));
        list.add(demo);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        // 这里也要保存数据，确保最后遗留的数据也存到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }


    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        for (Demo demo:list){
            demoDao.insert(demo);
        }
        LOGGER.info("存储数据库成功！");
    }
}
