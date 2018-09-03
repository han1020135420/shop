package manman.pro.os.web;

import manman.pro.core.util.CharUtil;
import manman.pro.core.util.ResponseUtil;
import manman.pro.db.domain.ShopStorage;
import manman.pro.db.service.ShopStorageService;
import manman.pro.os.config.ObjectStorageConfig;
import manman.pro.os.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:19
 */
@RestController
@RequestMapping("/os/storage")
public class OsStorageController {

    @Autowired
    private ObjectStorageConfig osConfig;

    @Autowired
    private ShopStorageService shopStorageService;

    @Autowired
    private StorageService storageService;

    private String generateUrl(String key){
        return "http://" + osConfig.getAddress() + ":" + osConfig.getPort() + "/os/storage/fetch/" + key;
    }

    private String generateKey(String originalFilename){
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);

        String key = null;
        ShopStorage storageInfo = null;

        do{
            key = CharUtil.getRandomString(20) + suffix;
            storageInfo = shopStorageService.findByKey(key);
        }
        while(storageInfo != null);

        return key;
    }

    @PostMapping("/create")
    public Object create(@RequestParam("file")MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.badArgumentValue();
        }
        String key = generateKey(originalFilename);
        storageService.store(inputStream,key);

        String url = generateUrl(key);
        ShopStorage shopStorage = new ShopStorage();
        shopStorage.setName(originalFilename);
        shopStorage.setSize((int)file.getSize());
        shopStorage.setType(file.getContentType());
        shopStorage.setAddTime(LocalDateTime.now());
        shopStorage.setModified(LocalDateTime.now());
        shopStorage.setKey(key);
        shopStorage.setUrl(url);
        shopStorageService.add(shopStorage);
        return ResponseUtil.ok(shopStorage);
    }

    @GetMapping("/read")
    public Object read(Integer id){
        if (id == null){
            return ResponseUtil.badArgument();
        }
        ShopStorage shopStorage = shopStorageService.findById(id);
        if(shopStorage == null){
            return ResponseUtil.badArgumentValue();
        }
        return ResponseUtil.ok(shopStorage);
    }
}
