package data_mahasiswa;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;
/**
 *
 * @author SayMukhlisin
 */
public class data_mahasiswa {
    
    public static void main(String[] args) {
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
            .header("Content-Type", "application/json")
            .header("Cookie", "siakaditm1=8bpfvk8q65c6rnb8k7sadip7tp")
            .body("{\"token\":\"ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49\",\r\n\"query\":\"select * from t_mhs where angkatan = 2023 and deleted = 0 limit 200\"}")
            .asString();
    
    String jsonresponse = response.getBody();
    JSONObject obj = new JSONObject(jsonresponse);
    int rows = obj.getInt("rows");
    JSONArray results = obj.getJSONArray("results");
    
    if(rows !=0) {
        for (int i = 0; i < results.length(); i++) {
            JSONObject item = results.getJSONObject(i);
            String nama = item.getString("mhs_nama");
            System.out.println(nama);
            
        }
    }
    }
}

