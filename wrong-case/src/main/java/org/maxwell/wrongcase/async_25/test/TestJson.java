package org.maxwell.wrongcase.async_25.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/30 16:47
 */
@RestController
public class TestJson {


    @PostMapping("test/json")
    public JSONObject testJson(@RequestBody Map<String, Object> map) {
        String json = "{\"id\":\"5855\",\"editDate\":\"2023-03-30 11:32:56.052\",\"arrivalDate\":\"2022-11-24 10:44:32\",\"cusCustoms\":\"2208\",\"midwayStation\":\"5149\",\"lastCheckDate\":null,\"checkDate\":\"2022-11-23\",\"ciqAppOrg\":\"310001\",\"foodPort\":\"AEABU\",\"waterPort\":\"AEAJP\",\"sscecSscDate\":null,\"msaRecvTime\":null,\"cusArvSendTime\":null,\"cusArvRecvTime\":null,\"cus121SendTime\":null,\"cus121RecvTime\":null,\"cus131SendTime\":null,\"cus131RecvTime\":null,\"cus141SendTime\":null,\"cus141RecvTime\":null,\"ciqRecvTime\":null,\"ciqSendTime\":null,\"cusClearSendTime\":null,\"cusClearRecvTime\":null,\"cusNoClearSendTime\":null,\"cusNoClearRecvTime\":null,\"arrivalDateCus\":\"2022-11-24 10:44:32\",\"arvCrews\":[{\"id\":23618,\"crewName\":\"张三\",\"crewNameEn\":\"hf\",\"msaRankCode\":\"00\",\"msaRankName\":\"合格证见习\",\"cusRankCode\":\"14\",\"cusRankName\":\"甲板实习生\",\"cusNacode\":\"AO\",\"cusNaname\":\"安哥拉\",\"birthday\":\"2022-11-23 00:00:00.000\",\"birthPlace\":\"上海\",\"cusCerttype\":\"12\",\"cusCertname\":\"公务护照\",\"certNo\":\"A1234567\",\"cusGenderCode\":\"M\",\"cusGenderName\":\"男\",\"memo\":null,\"rankCertNo\":\"A1234567\",\"certExpireDate\":\"2022-11-30 00:00:00.000\",\"boardingShipDate\":\"2022-11-22 00:00:00.000\",\"boardingShipPortCode\":\"RUARH\",\"boardingShipPortName\":\"阿尔汉格尔/阿尔汉格尔斯克\",\"personType\":\"1\",\"msaNacode\":\"AO\",\"msaNaname\":\"安哥拉\",\"msaCerttype\":null,\"msaCertname\":\"护照\"},{\"id\":23619,\"crewName\":\"retre\",\"crewNameEn\":\"34\",\"msaRankCode\":\"51\",\"msaRankName\":\"船长\",\"cusRankCode\":\"1\",\"cusRankName\":\"船长\",\"cusNacode\":\"PS\",\"cusNaname\":\"巴勒斯坦\",\"birthday\":\"2013-11-01 00:00:00.000\",\"birthPlace\":\"545\",\"cusCerttype\":\"12\",\"cusCertname\":\"公务护照\",\"certNo\":\"34\",\"cusGenderCode\":\"F\",\"cusGenderName\":\"女\",\"memo\":null,\"rankCertNo\":\"44\",\"certExpireDate\":\"2022-11-30 00:00:00.000\",\"boardingShipDate\":\"2022-11-23 00:00:00.000\",\"boardingShipPortCode\":\"FRTLN\",\"boardingShipPortName\":\"土伦\",\"personType\":\"1\",\"msaNacode\":null,\"msaNaname\":null,\"msaCerttype\":null,\"msaCertname\":\"护照\"}],\"arvCrewcargos\":[{\"id\":6209,\"cusCerttype\":\"12\",\"cusCertname\":\"公务护照\",\"certNo\":\"A1234567\",\"crewGoodsNo\":null,\"goodsType\":\"0201\",\"goodsName\":\"545\",\"goodsQty\":4,\"goodsUnitCode\":\"007\",\"goodsUnitName\":\"个\",\"memo\":null,\"plantNum\":44,\"petNum\":44},{\"id\":6210,\"cusCerttype\":\"12\",\"cusCertname\":\"公务护照\",\"certNo\":\"A1234567\",\"crewGoodsNo\":null,\"goodsType\":\"0100\",\"goodsName\":\"766\",\"goodsQty\":1,\"goodsUnitCode\":\"007\",\"goodsUnitName\":\"个\",\"memo\":null,\"plantNum\":1,\"petNum\":1}],\"arvCerts\":[{\"id\":5676,\"certId\":null,\"certTypeCode\":\"1101\",\"certTypeName\":\"国籍证书\",\"assignDate\":\"2020-12-23 00:00:00.000\",\"isValid\":\"0\",\"expireDate\":\"9999-12-31 00:00:00.000\",\"checkTypeCode\":null,\"checkTypeName\":null,\"checkDate\":\"\",\"memo\":null}],\"arvCtns\":[{\"id\":2344,\"ctnId\":null,\"ctnType\":\"005\",\"emptyCtnNumber\":43,\"fullCtnNumber\":2,\"ctnTypeName\":\"45英尺\"}],\"arvPorts\":[{\"id\":6616,\"arrivedDate\":\"2022-11-23 10:46:59.000\",\"saillingDate\":\"2022-11-23 10:47:13.000\",\"cusPortCode\":\"AEAJM\",\"cusPortName\":\"阿吉曼\",\"memo\":\"4242\"}],\"arvCargos\":[{\"id\":5593,\"cargoId\":null,\"loadPortCode\":\"TNSUS\",\"loadPortName\":\"苏萨/苏塞\",\"dischargePortCode\":\"TNSUS\",\"dischargePortName\":\"苏萨/苏塞\",\"signMark\":\"N/M\",\"cusCargoTypeCode\":\"02\",\"cusCargoTypeName\":\"石油、天然气及制品\",\"ctnType\":\"4CP3\",\"fullOrEmpty\":\"1\",\"wrapCode\":\"AE\",\"wrapName\":\"按扭式喷雾器瓶\",\"cargoQty\":34,\"cargoWeight\":34,\"unitCode\":\"002\",\"unitName\":\"座\",\"cargoDesc\":\"34\",\"memo\":\"34\",\"loadingSign\":\"0\"}],\"arvCargoMsas\":[],\"arvDangerouses\":[],\"arvShipcargos\":[{\"id\":5813,\"goodsNo\":null,\"goodsType\":\"3\",\"goodsName\":\"343\",\"goodsQty\":3,\"goodsUnitCode\":\"007\",\"goodsUnitName\":\"个\",\"depositary\":\"34\",\"memo\":null,\"goodsPlaceCode\":\"SSD\",\"goodsPlaceName\":\"南苏丹共和国\",\"loadingPortCode\":\"FRTLN\",\"loadingPortName\":\"土伦\"}],\"arvInnerCargos\":[],\"arvTransCargos\":[],\"arvEmptyCtns\":[],\"arvLighters\":[],\"arvHealths\":[],\"arvBallastwaterEmission\":[],\"arvBallastwaterExchange\":[],\"arvBallastwaterPump\":[]}";
        JSONObject jsonObject = JSON.parseObject(json);
        removeNullField(jsonObject, "lastCheckDate");
        return jsonObject;
    }


    /**
     * 去除空的json 字段
     *
     * @param jsonObject
     * @param fields
     */
    public static void removeNullField(JSONObject jsonObject, String... fields) {
        for (String field : fields) {
            if (jsonObject.get(field) == null) {
                System.out.println("~~~ 输出：" + jsonObject.get(field));
                jsonObject.remove(field);
            }
            if ("null".equals(jsonObject.get(field))) {
                System.out.println("~~~ 输出：" + jsonObject.get(field));
                jsonObject.remove(field);
            }
        }
    }

}
