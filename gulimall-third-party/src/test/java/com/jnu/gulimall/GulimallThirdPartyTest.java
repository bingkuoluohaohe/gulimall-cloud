package com.jnu.gulimall;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @createTime : [2022/8/10 12:25]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class GulimallThirdPartyTest {

    @Resource
    private OSSClient ossClient;

    @Test
    public void testUpload() throws FileNotFoundException {
        String bucketName = "gulimall-ych-hello";
        String objectName = "9bb7af1f057cc7cfcfef2bdc660a3144.jpeg";
        String filePath = "D:\\视频\\Saved Pictures\\9bb7af1f057cc7cfcfef2bdc660a3144.jpeg";

        try {
            InputStream inputStream = new FileInputStream(filePath);
            ossClient.putObject(bucketName, objectName, inputStream);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            log.debug("上传成功");
        }
    }

}