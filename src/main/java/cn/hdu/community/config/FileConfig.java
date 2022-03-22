package cn.hdu.community.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author zhangxin
 * @Date 2022/3/17
 */
public class FileConfig {
    //文件存放的路径 若没有 会自动创建
    public static final String PATH = System.getProperty("user.dir") + "/src/main/resources/static/upload/";

    /**
     * 上传文件 如果上传错误 会返回空的地址 注意 返回的地址是用来回显的 所以不要返回布尔类型
     */
    public static String upload(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return "";
        }
        String filename = multipartFile.getOriginalFilename();
        File file = new File(PATH);
        if (!file.exists()) {
            //使用mkdirs 若某个目录不存在 也会一起创建
            file.mkdirs();
        }
        //为了不使得图片名字重复 使用uuid拼接
        int i = filename.lastIndexOf(".");
        String suffix = filename.substring(i - 1);
        String newFileName = UUID.randomUUID().toString() + suffix;
        try {
            multipartFile.transferTo(new File(PATH + newFileName));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return newFileName;
    }
}
