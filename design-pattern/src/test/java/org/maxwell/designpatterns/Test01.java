package org.maxwell.designpatterns;

import org.junit.Test;
import org.maxwell.designpatterns.singleton.IdGeneratorEnum;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/30 16:51
 */
public class Test01 {

    @Test
    public void testFactory(){

        IdGeneratorEnum.INSTANCE.getId();

    }



}
