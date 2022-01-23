package ws.spring.validate.hiddenskills.service;

import javax.validation.constraints.Min;

/**
 * 模拟一个业务接口
 * @author WindShadow
 * @date 2021-11-20.
 */

public interface CustomService {

    /**
     * 有参数的方法
     * @param number
     */
    void doSomethingParam(Integer number);

    /**
     * 有返回值的方法
     * @return
     */
    String doSomethingReturn();

    @Min(10)
    int returnInt();
}
