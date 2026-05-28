package protocol;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ProductRequestDto;
import dto.ProductResponseDto;

public class MessageParser {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ProductRequestDto parseRequest(String jsonMessage){
        try{
            return objectMapper.readValue(jsonMessage, ProductRequestDto.class);
        }catch (Exception e){
            throw new IllegalArgumentException("JSON 파싱 중 오류가 발생했습니다.", e);
        }
    }

    public String toJson(Object responseDto){
        try {
            return  objectMapper.writeValueAsString(responseDto);
        }catch (Exception e){
            throw new RuntimeException("JSON 변환 중 오류가 발생했습니다.", e);
        }
    }
}
