package org.maxwell.wrongcase.apidesign_22.apiversion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 13:22
 */
@RequestMapping("apiversion")
@RestController
public class VersionController {

    @GetMapping("/api/item/v1")
    public void wrong1(){
    }


    @GetMapping("/api/v1/shop")
    public void wrong2(){
    }


    @GetMapping("/v1/api/merchant")
    public void wrong3(){
    }



    @GetMapping(value = "/api/user")
    @APIVersion("v4")
    public int right4() {
        return 4;
    }


}
