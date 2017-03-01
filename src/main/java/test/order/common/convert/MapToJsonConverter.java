package test.order.common.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Converter
public class MapToJsonConverter implements AttributeConverter<Map, String> {

    Logger log = LoggerFactory.getLogger(getClass());

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map attribute) {

        String result = null;

        try {
            result = mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            log.error("json convert fail", e);
        }

        return result;
    }

    @Override
    public Map convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, Map.class);
        } catch (IOException e) {
            log.error("json convert fail dbData={}", dbData, e);
        }
        return null;
    }

}
