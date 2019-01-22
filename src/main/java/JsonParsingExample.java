import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;

public class JsonParsingExample {
    public static void main(String[] args){
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User();
        user.setId(1);
        user.setName("Json's");
        user.setDescription("Name with single quote and  \\/backslash");
        StringWriter writer = new StringWriter();
        try {
            objectMapper.getJsonFactory().setCharacterEscapes(new HTMLCharacterEscapes());
            objectMapper.writeValue(writer,user);
            System.out.println("Json => " + writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
