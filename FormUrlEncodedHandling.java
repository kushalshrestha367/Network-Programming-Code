import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FormUrlEncodedHandling {
    public static void main(String[] args) {
        String formData = "name=John Doe&email=johndoe@example.com&city=New York";

        String encodedData = encodeFormData(formData);
        System.out.println("Encoded Data: " + encodedData);

        String decodedData = decodeFormData(encodedData);
        System.out.println("Decoded Data: " + decodedData);
    }

    private static String encodeFormData(String data) {
        try {
            String[] pairs = data.split("&");
            StringBuilder encodedData = new StringBuilder();
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                String key = URLEncoder.encode(pair.substring(0, idx), StandardCharsets.UTF_8.toString());
                String value = URLEncoder.encode(pair.substring(idx + 1), StandardCharsets.UTF_8.toString());
                if (encodedData.length() > 0) {
                    encodedData.append("&");
                }
                encodedData.append(key).append("=").append(value);
            }
            return encodedData.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String decodeFormData(String data) {
        try {
            String[] pairs = data.split("&");
            StringBuilder decodedData = new StringBuilder();
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                String key = URLDecoder.decode(pair.substring(0, idx), StandardCharsets.UTF_8.toString());
                String value = URLDecoder.decode(pair.substring(idx + 1), StandardCharsets.UTF_8.toString());
                if (decodedData.length() > 0) {
                    decodedData.append("&");
                }
                decodedData.append(key).append("=").append(value);
            }
            return decodedData.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
