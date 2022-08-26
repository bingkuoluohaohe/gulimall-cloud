package com.jnu.gulimall.product.web;

import com.jnu.gulimall.product.entity.CategoryEntity;
import com.jnu.gulimall.product.service.CategoryService;
import com.jnu.gulimall.product.vo.Catalog2Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author zr
 * @date 2021/10/27 15:23
 */
@Controller
public class IndexController {
    @Resource
    private CategoryService categoryService;

//    @Resource
//    private RedissonClient redissonClient;

//    @Resource
//    private StringRedisTemplate redisTemplate;

    @GetMapping({"/", "index.html"})
    public String indexPage(Model model) {
        // TODO 1、查出所有1级分类
        List<CategoryEntity> categoryEntitys = categoryService.getLevel1Categorys();
        model.addAttribute("categorys", categoryEntitys);
        return "index";
    }

    /**
     * 查出三级分类
     * 1级分类作为key，2级引用List
     */
    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catalog2Vo>> getCatalogJson() {
        Map<String, List<Catalog2Vo>> map = categoryService.getCatalogJson();
        return map;
    }

//    @GetMapping("/setLatch")
//    @ResponseBody
//    public String setLatch() {
//        RCountDownLatch latch = redissonClient.getCountDownLatch("CountDownLatch");
//        try {
//            latch.trySetCount(5);
//            latch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "门栓被放开";
//    }

//    @GetMapping("/offLatch")
//    @ResponseBody
//    public String offLatch() {
//        RCountDownLatch latch = redissonClient.getCountDownLatch("CountDownLatch");
//        latch.countDown();
//        return "门栓被放开1";
//    }

//    @GetMapping("/park")
//    @ResponseBody
//    public String park() {
//        RSemaphore park = redissonClient.getSemaphore("park");
//        try {
//            park.acquire(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "停进2";
//    }

//    @GetMapping("/go")
//    @ResponseBody
//    public String go() {
//        RSemaphore park = redissonClient.getSemaphore("park");
//        park.release(2);
//        return "开走2";
//    }

//    @GetMapping("/read")
//    @ResponseBody
//    public String read() {
//        RReadWriteLock lock = redissonClient.getReadWriteLock("ReadWrite-Lock");
//        RLock rLock = lock.readLock();
//        String s = "";
//        try {
//            rLock.lock();
//            System.out.println("读锁加锁" + Thread.currentThread().getId());
//            Thread.sleep(5000);
//            s = redisTemplate.opsForValue().get("lock-value");
//        } finally {
//            rLock.unlock();
//            return "读取完成:" + s;
//        }
//    }

//    @GetMapping("/write")
//    @ResponseBody
//    public String write() {
//        RReadWriteLock lock = redissonClient.getReadWriteLock("ReadWrite-Lock");
//        RLock wLock = lock.writeLock();
//        String s = UUID.randomUUID().toString();
//        try {
//            wLock.lock();
//            System.out.println("写锁加锁" + Thread.currentThread().getId());
//            Thread.sleep(10000);
//            redisTemplate.opsForValue().set("lock-value", s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            wLock.unlock();
//            return "写入完成:" + s;
//        }
//    }

//    @ResponseBody
//    @GetMapping("/hello")
//    public String hello() {
//        //1.获取一把锁,只要锁的名字一样,就是同一把锁
//        RLock lock = redissonClient.getLock("my-lock");
//        //加锁
//        lock.lock(10, TimeUnit.SECONDS);//阻塞式等待,默认加的锁等待时间为30s
//        //1.锁的自动续期,如果在业务执行期间业务没有执行完成,redisson会为该锁自动续期
//        //2.加锁的业务只要运行完成,就不会自动续期,即使不手动解锁,锁在默认的30s后会自动删除
//        try {
//            System.out.println("加锁成功,执行业务......" + Thread.currentThread().getId());
//            Thread.sleep(30000);
//        } catch (Exception e) {
//
//        } finally {
//            //解锁,假设代码没有运行,redisson不会出现死锁
//            System.out.println("锁释放..." + Thread.currentThread().getId());
//            lock.unlock();
//        }
//        return "hello";
//    }
}
