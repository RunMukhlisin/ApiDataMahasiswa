package kelas;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author SayMukhlisin
 */
public class mahasiswa {

    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query;
    private static JSONArray dataMhs;
    private static int baris;

    public static int getBaris() {
        return baris;
    }

    public static void setBaris(int baris) {
        mahasiswa.baris = baris;
    }

    public static JSONArray getDataMhs() {
        return dataMhs;
    }

    public static void setDataMhs(JSONArray dataMhs) {
        mahasiswa.dataMhs = dataMhs;
    }
    
    public JSONObject getMahasiswa() {
        query = "select * from t_mhs where angkatan = 2023 and deleted = 0 limit 200";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=8bpfvk8q65c6rnb8k7sadip7tp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();
        
        
        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);

        return obj;
    }


    public static ImageIcon decodeBase64ToImage(String base64String, int width, int height) {
        try {
            if (base64String.contains(",")) {
                base64String = base64String.split(",")[1];
            }

            byte[] decodeBytes = Base64.getDecoder().decode(base64String);
            ByteArrayInputStream bas = new ByteArrayInputStream(decodeBytes);
            BufferedImage bufferedImage = ImageIO.read(bas);
            ImageIcon image = new ImageIcon(bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));

            return image;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
    
    
