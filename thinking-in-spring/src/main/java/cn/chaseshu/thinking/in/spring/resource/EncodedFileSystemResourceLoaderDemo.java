package cn.chaseshu.thinking.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @see FileSystemResourceLoader
 * @see EncodedResource
 */
public class EncodedFileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {

        String currentJavaFilePath = "/" + System.getProperty("user.dir") + "/src/main/java/cn/chaseshu/thinking/in/spring/resource/EncodedFileSystemResourceLoaderDemo.java";

        System.out.println(currentJavaFilePath);
        FileSystemResourceLoader resourceLoader = new FileSystemResourceLoader();
        Resource resource = resourceLoader.getResource(currentJavaFilePath);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        System.out.println(encodedResource);
        Reader reader = encodedResource.getReader();
        String s = IOUtils.toString(reader);
        System.out.println(s);


    }
}
