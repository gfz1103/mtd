package com.buit.utill;

import java.math.BigDecimal;

/**
 * @Author zhouhaisheng
 * @Description //TODO $
 * @Date $ $
 * @Param $
 * @return $
 **/
@FunctionalInterface
public interface ToBigDecimalFunction<T> {
    BigDecimal applyAsBigDecimal(T value);
}
