package com.example.sell.utils.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * 用来将数据库里的毫秒级别的时间戳除以1000，加在类上
 * @author ZRL
 * @date 2020/12/9 22:40
 */
public class Data2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime()/1000);
    }
}
