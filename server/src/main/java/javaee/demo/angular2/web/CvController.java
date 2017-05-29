package javaee.demo.angular2.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Yehoshua on 01.02.17.
 */

@RestController
@CrossOrigin()
public class CvController {

    private static String imagesPath = "/json/";
    private static String imageName = "cv.json";
    private static String imageNameOld = "cv-old.json";

   @RequestMapping(value = "/rest/cv/yehoshua", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
        String  result() throws IOException {
        InputStream stream = new ClassPathResource(imagesPath + imageName).getInputStream();

       java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
       return s.hasNext() ? s.next() : "";
    }

    @RequestMapping(value = "/rest/cv/old-cv", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    String  oldCv() throws IOException {
        InputStream stream = new ClassPathResource(imagesPath + imageNameOld).getInputStream();

        java.util.Scanner s = new java.util.Scanner(stream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


}
